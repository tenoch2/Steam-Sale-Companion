import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.exceptions.SteamApiException;

public class ListMaker {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String[] args) throws SteamApiException {
		
		
		SteamApi steam = new SteamApi("US");
		List<String> gameNames;
		List<SteamApp> steamGames;
		Map<SteamApp,Double> results;
		
		try {
			gameNames = getGameNames("GameNames.txt");
			steamGames = new ArrayList<SteamApp>();
			for(String name : gameNames){
				steamGames.add(steam.retrieve(name));
			}
			steamGames.forEach(game -> System.out.println(game.getName()));
			
			
			results = scoreGames(steamGames);
			
			for (SteamApp key : results.keySet()) {
				System.out.printf("%s | score: %n", key.getName(), results.get(key));
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("end API test");
		
	
		
	
	
		

	}

	public static Map<SteamApp,Double> scoreGames(List<SteamApp> games) {

		Map<SteamApp,Double> gameResults = new HashMap<SteamApp,Double>();

		int costRate = 40;
		int saleRate = 30;
		int reviewRate = 10;
		
		System.out
				.println("cost rate : " + costRate + ", sale Rate : " + saleRate + ", review rate : " + reviewRate);
		
		gameResults = generateScores(games, costRate, saleRate, reviewRate);
		return gameResults;
	}

	private static Map<SteamApp,Double> generateScores(List<SteamApp> games, int costRate, int saleRate, int reviewRate) {

		double priceWeight;
		double reviewWeight;
		double saleWeight;
		List<SteamApp> results = new ArrayList<SteamApp>();
		GameListingFactory gameListings = new GameListingFactory();
		double lowestPrice = getLowestCost(games);
		Map<SteamApp,Double> gameWithScores = new HashMap<SteamApp,Double>();

		for (SteamApp game : games) {

			priceWeight =  (Math.sqrt(lowestPrice / game.getPrice()) * costRate);
			saleWeight =  (game.getPriceDiscountPercentage() / 100 * saleRate);
			reviewWeight =  (reviewRate / game.getMetacriticScore());
			double score = priceWeight + saleWeight + reviewWeight;

			SteamApp gameToList = gameListings.enlistGame(game.getName(), game.getPrice(), (double)((double)game.getPriceDiscountPercentage() / 100),
					game.getMetacriticScore());
			
			gameWithScores.put(gameToList, score);

			results.add(gameToList);
		}
		
		
		
		return gameWithScores;
	}

	
	public static List<SteamApp> sortGameList(Map<SteamApp,Double> games) {
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

	
	public static List<String> getGameNames(String fileName) throws IOException{
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

}
