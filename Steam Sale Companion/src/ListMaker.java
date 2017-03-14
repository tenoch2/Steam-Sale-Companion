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
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.exceptions.SteamApiException;
import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.GameStats;
import com.github.koraktor.steamcondenser.steam.community.SteamGame;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

public class ListMaker {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws SteamApiException {

		//Initialize the necessary variables and data structures
		SteamApi steam = new SteamApi("US");
		
		//List of the game names to be turned into Objects from the Steam API
		List<String> gameNames = new ArrayList<String>();
		
		//Where games will be downloaded into
		List<SteamApp> steamGames;

		//The SteamApps paired with their scores
		List<Game> results;
		
		SteamId id;
		int usrChoice = 0;
		Scanner inp = new Scanner(System.in);

		//choose import method
		do {
			System.out.println("would you like to input games from wishlist or text file? \n" + "1 for wishlist \n"
					+ "2 for text file");
			usrChoice = inp.nextInt();
		} while (usrChoice != 1 && usrChoice != 2);

		if (usrChoice == 1) {
			// Import from wishlist
			try {

				System.out.print("Input custom URL tag for steam user: ");

				id = SteamId.create(inp.next());
				String url = id.getBaseUrl() + "/wishlist";
				gameNames = getGameNamesFromWishList(url);

			} catch (SteamCondenserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (usrChoice == 2) {
			// Import from text file
			try {
				
				gameNames = getGameNames("GameNames.txt");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		steamGames = new ArrayList<SteamApp>();
		System.out.println("Retrieving game data...");

		//populate the list with game data
		for (String name : gameNames) {
			steamGames.add(steam.retrieve(name));
		}

		//populate and store games' scores
		results = scoreGames(steamGames);
		
		//print to window
		printGameList(results);

		//debug line
		System.out.println("done");
		inp.close();
	}

	//prints a collection of Game objects in a clean format
	public static void printGameList(List<Game> games) {
		int i = 1;
		for (Game game : games) {
			System.out.printf("%d : %s | score: %.3f ", i++, game.getSteamGame().getName(), game.getScore());
			if (game.getSteamGame().isFreeToPlay())
				System.out.print(game.getSteamGame().getName() + " is free to play!");
			System.out.println("");
		}
	}

	
	public static List<Game> scoreGames(List<SteamApp> games) {
		
		//the list that will be returned
		List<Game> gameResults = new ArrayList<Game>();

		//the rates. Feel free to play around with them. These will be changed via GUI in the future
		//For clean and accurate results, MUST sum 100
		double priceRate = 50;
		double saleRate = 10;
		double reviewRate = 40;

		//print rates to main menu
		System.out.println("price rate : " + (int) priceRate + "%, sale Rate : " + (int) saleRate + "%, review rate : "
				+ (int) reviewRate + "%");
		
		//fetch and score games list
		gameResults = generateScores(games, priceRate, saleRate, reviewRate);
		
		//return populated list
		return gameResults;
	}

	private static List<Game> generateScores(List<SteamApp> games, double priceRate, double saleRate,
			double reviewRate) {

		double priceWeight;
		double reviewWeight;
		double saleWeight;
		
		//fetch lowest score for weighting
		double lowestPrice = getLowestCost(games);
		
		//fetch highest score for weighting
		double highestScore = getHighestScore(games);
		
		List<Game> gameWithScores = new ArrayList<Game>();

		for (SteamApp game : games) {

			if (game.getPrice() > 0)
				priceWeight = (Math.sqrt(lowestPrice / game.getPrice()) * priceRate);
			else //this catches free games that would orignally break program
				priceWeight = priceRate;

			double salePercent = game.getPriceDiscountPercentage();
			saleWeight = (salePercent / (double) 100 * saleRate);

			if (game.getMetacriticScore() != null)
				reviewWeight = (Math.sqrt((Math.sqrt((highestScore / (double) game.getMetacriticScore())))))
						* reviewRate;
			else //not every game has metacritic score. Main reason we are working on implementing user review scores for now.
				reviewWeight = 0;
			
			
			//game's score is all the weights summed. create game object, add to list, move on to the next SteamApp.
			double score = priceWeight + saleWeight + reviewWeight;
			Game newGame = new Game(game, score);
			gameWithScores.add(newGame);
		}

		//sort by score in descending order
		sortGameList(gameWithScores);
		return gameWithScores;
	}

	//Custom sort
	public static List<Game> sortGameList(List<Game> games) {
		Collections.sort(games, new Comparator<Game>() {
			public int compare(Game g1, Game g2) {
				return g1.getScore() > g2.getScore() ? -1 : (g1.getScore() < g2.getScore()) ? 1 : 0;
			}
		});
		return games;
	}

	//find the game with the lowest cost and return its cost
	private static double getLowestCost(List<SteamApp> games) {
		double lowest = Integer.MAX_VALUE;
		for (SteamApp game : games) {
			double price = game.getPrice();
			if (price < lowest && price != 0)
				lowest = price;
		}
		return lowest;
	}
	
	//find the game with the highest cost and return its cost
	private static double getHighestScore(List<SteamApp> games) {
		double highest = 0;
		for (SteamApp game : games) {
			if (game.getMetacriticScore() != null) {
				double score = game.getMetacriticScore();
				if (score > highest)
					highest = score;
			}

		}
		return highest;
	}

	//retrieves game names via webscrapping API JSoup
	public static List<String> getGameNamesFromWishList(String url) throws IOException {

		List<String> results = new ArrayList<String>();
		Document userUrl = Jsoup.connect(url).get();
		
		//go through every HTML row of "wishlistRow" from the website and store it in string list
		for (Element row : userUrl.select(".wishlistRow")) {
			final String title = row.select("h4").text();
			results.add(title);
		}

		return results;
	}

	//straight reading from text file
	public static List<String> getGameNames(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

}
