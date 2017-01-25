import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.exceptions.SteamApiException;

public class ListMaker {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws SteamApiException {
		Stack<String> gameNames;
		List<SteamApp> steamGames = new ArrayList<SteamApp>();
		List<Game> results;
		try {
			gameNames = getGameNames("GameNames.txt");
			List<String> gameNames1 = new ArrayList<String>();
			List<String> gameNames2 = new ArrayList<String>();

			int iterator = 0;
			while (!gameNames.empty()) {
				if (iterator < gameNames.size() / 2)
					gameNames1.add(gameNames.pop());
				else
					gameNames2.add(gameNames.pop());
				iterator++;
			}

			Game_Retriever gameFetcher1 = new Game_Retriever("fetcher1", gameNames1);
			Game_Retriever gameFetcher2 = new Game_Retriever("fetcher2", gameNames2);
			Game_Retriever[] threads = { gameFetcher1, gameFetcher2 };
			gameFetcher1.start();
			gameFetcher2.start();
	        
			for(int i = 0 ; i < threads.length; i++){
				threads[i].join();
			}
			
			steamGames = gameFetcher1.getSteamGames();
			steamGames.addAll(gameFetcher2.getSteamGames());

			results = scoreGames(steamGames);

			for (Game game : results) {
				System.out.printf("%s | score: %.2f \n", game.getSteamGame().getName(), game.getScore());
			}

		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public static List<Game> scoreGames(List<SteamApp> games) {

		List<Game> gameResults = new ArrayList<Game>();

		int costRate = 40;
		int saleRate = 20;
		int reviewRate = 40;

		System.out.println("cost rate : " + costRate + ", sale Rate : " + saleRate + ", review rate : " + reviewRate);

		gameResults = generateScores(games, costRate, saleRate, reviewRate);
		return gameResults;
	}

	private static List<Game> generateScores(List<SteamApp> games, int costRate, int saleRate, int reviewRate) {

		double priceWeight;
		double reviewWeight;
		double saleWeight;
		double lowestPrice = getLowestCost(games);
		List<Game> gameWithScores = new ArrayList<Game>();

		for (SteamApp game : games) {

			priceWeight = (Math.sqrt(lowestPrice / game.getPrice()) * costRate);
			saleWeight = (game.getPriceDiscountPercentage() / 100 * saleRate);

			if (game.getMetacriticScore() != null)
				reviewWeight = (reviewRate / (double) game.getMetacriticScore());
			else
				reviewWeight = 0;

			double score = priceWeight + saleWeight + reviewWeight;
			Game newGame = new Game(game, score);
			gameWithScores.add(newGame);
		}

		return gameWithScores;
	}

	public static List<SteamApp> sortGameList(List<Game> games) {
		throw new UnsupportedOperationException();
	}

	private static double getLowestCost(List<SteamApp> games) {
		double lowest = Integer.MAX_VALUE;
		for (SteamApp game : games) {
			if (game.getPrice() < lowest)
				lowest = game.getPrice();
		}
		return lowest;

	}

	public static Stack<String> getGameNames(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		List<String> names = Files.readAllLines(path, ENCODING);
		Stack<String> results = new Stack<String>();
		names.forEach(name -> results.push(name));
		return results;
	}

}
