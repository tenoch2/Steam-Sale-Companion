import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.exceptions.SteamApiException;

public class ListMaker {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws SteamApiException {

            MainBox box = new MainBox();
            box.setVisible(true);
            
    //Used for testing purposes and proof of concept only        
//		SteamApi steam = new SteamApi("US");
//		List<String> gameNames;
//		List<SteamApp> steamGames;
//		List<Game> results;
//
//		try {
//			
//			gameNames = getGameNames("GameNames.txt");
//			steamGames = new ArrayList<SteamApp>();
//			
//			System.out.println("Retrieving game data...");
//			for (String name : gameNames) {
//				steamGames.add(steam.retrieve(name));
//			}
//			results = scoreGames(steamGames);
//			int i = 1;
//			for (Game game : results) {
//				System.out.printf("%d : %s | score: %.5f \n", i, game.getSteamGame().getName(), game.getScore());
//				i++;
//			}
//			System.out.println("done");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//
//	}
//
//	public static List<Game> scoreGames(List<SteamApp> games) {
//
//		List<Game> gameResults = new ArrayList<Game>();
//
//		double priceRate = 30;
//		double saleRate = 10;
//		double reviewRate = 60;
//
//
//		System.out.println("price rate : " + priceRate + ", sale Rate : " + saleRate + ", review rate : " + reviewRate);
//
//		gameResults = generateScores(games, priceRate, saleRate, reviewRate);
//		return gameResults;
//	}
//
//	private static List<Game> generateScores(List<SteamApp> games, double priceRate, double saleRate,
//			double reviewRate) {
//
//		double priceWeight;
//		double reviewWeight;
//		double saleWeight;
//		double lowestPrice = getLowestCost(games);
//		double highestScore = getHighestScore(games);
//		List<Game> gameWithScores = new ArrayList<Game>();
//
//		for (SteamApp game : games) {
//
//			if (game.getPrice() > 0)
//				priceWeight = (Math.sqrt(lowestPrice / game.getPrice()) * priceRate);
//			else
//				priceWeight = priceRate;
//
//			saleWeight = (game.getPriceDiscountPercentage() / 100 * saleRate);
//
//			if (game.getMetacriticScore() != null)
//				reviewWeight = (Math.sqrt((Math.sqrt((highestScore / (double) game.getMetacriticScore()))))) * reviewRate;
//			else {
//				reviewWeight = 0;
//			}
//
//			double score = priceWeight + saleWeight + reviewWeight;
//			Game newGame = new Game(game, score);
//			gameWithScores.add(newGame);
//		}
//
//		sortGameList(gameWithScores);
//		return gameWithScores;
//	}
//
//	public static List<Game> sortGameList(List<Game> games) {
//		Collections.sort(games, new Comparator<Game>() {
//			public int compare(Game g1, Game g2) {
//				return g1.getScore() > g2.getScore() ? -1 : (g1.getScore() < g2.getScore()) ? 1 : 0;
//			}
//		});
//		return games;
//	}
//
//	private static double getLowestCost(List<SteamApp> games) {
//		double lowest = Integer.MAX_VALUE;
//		for (SteamApp game : games) {
//			double price = game.getPrice();
//			if (price < lowest && price != 0)
//				lowest = price;
//		}
//		return lowest;
//	}
//
//	private static double getHighestScore(List<SteamApp> games) {
//		double highest = 0;
//		for (SteamApp game : games) {
//			if (game.getMetacriticScore() != null) {
//				double score = game.getMetacriticScore();
//				if (score > highest)
//					highest = score;
//			} else
//				;
//		}
//		return highest;
//	}
//
//	public static List<String> getGameNames(String fileName) throws IOException {
//		Path path = Paths.get(fileName);
//		return Files.readAllLines(path, ENCODING);
	}

}
