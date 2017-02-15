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

		SteamApi steam = new SteamApi("US");
		List<String> gameNames = new ArrayList<String>();
		List<SteamApp> steamGames;
		List<Game> results;
		SteamId id;
		int usrChoice = 0;
		Scanner inp = new Scanner(System.in);

		do {
			System.out.println("would you like to input games from wishlist or text file? \n" + "1 for wishlist \n"
					+ "2 for text file");
			usrChoice = inp.nextInt();
		} while (usrChoice != 1 && usrChoice != 2);

		if (usrChoice == 1) {

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

			try {

				gameNames = getGameNames("GameNames.txt");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		steamGames = new ArrayList<SteamApp>();
		System.out.println("Retrieving game data...");

		for (String name : gameNames) {
			steamGames.add(steam.retrieve(name));
		}

		SteamApp portal = steam.retrieve(400);
		System.out.println("portal's user review score: ");
		try {
			System.out.println(getGameUserScore(portal));
		} catch (IOException e) {
			e.printStackTrace();
		}

		results = scoreGames(steamGames);
		printGameList(results);

		System.out.println("done");
		inp.close();

	}

	public static void printGameList(List<Game> games) {
		int i = 1;
		for (Game game : games) {

			System.out.printf("%d : %s | score: %.3f \n", i++, game.getSteamGame().getName(), game.getScore());
		}
	}

	public static List<Game> scoreGames(List<SteamApp> games) {

		List<Game> gameResults = new ArrayList<Game>();

		double priceRate = 50;
		double saleRate = 10;
		double reviewRate = 40;

		System.out.println("price rate : " + priceRate + ", sale Rate : " + saleRate + ", review rate : " + reviewRate);

		gameResults = generateScores(games, priceRate, saleRate, reviewRate);
		return gameResults;
	}

	private static List<Game> generateScores(List<SteamApp> games, double priceRate, double saleRate,
			double reviewRate) {

		double priceWeight;
		double reviewWeight;
		double saleWeight;
		double lowestPrice = getLowestCost(games);
		double highestScore = getHighestScore(games);
		List<Game> gameWithScores = new ArrayList<Game>();

		for (SteamApp game : games) {

			if (game.getPrice() > 0)
				priceWeight = (Math.sqrt(lowestPrice / game.getPrice()) * priceRate);
			else
				priceWeight = priceRate;

			saleWeight = (game.getPriceDiscountPercentage() / 100 * saleRate);

			if (game.getMetacriticScore() != null)
				reviewWeight = (Math.sqrt((Math.sqrt((highestScore / (double) game.getMetacriticScore())))))
						* reviewRate;
			else {
				reviewWeight = 0;
			}

			double score = priceWeight + saleWeight + reviewWeight;
			Game newGame = new Game(game, score);

			gameWithScores.add(newGame);
		}

		sortGameList(gameWithScores);
		return gameWithScores;
	}

	public static int getGameUserScore(SteamApp game) throws IOException {
		String target = " ";
		Document gameUrl = Jsoup.connect("http://store.steampowered.com/app/" + game.getAppId() + "/").get();
		
		for (Element row : gameUrl.select(".summary column")) {
			String[] reviewLine = row.select(".nonresponsive_hidden responsive_reviewdesc").text().split("//s+");
			target = reviewLine[0].substring(0, 1);
		}

		if (!target.matches("^[1-9]\\d*$")) {
			return 0;
		} else
			return Integer.parseInt(target);
	}

	public static List<Game> sortGameList(List<Game> games) {
		Collections.sort(games, new Comparator<Game>() {
			public int compare(Game g1, Game g2) {
				return g1.getScore() > g2.getScore() ? -1 : (g1.getScore() < g2.getScore()) ? 1 : 0;
			}
		});
		return games;
	}

	private static double getLowestCost(List<SteamApp> games) {
		double lowest = Integer.MAX_VALUE;
		for (SteamApp game : games) {
			double price = game.getPrice();
			if (price < lowest && price != 0)
				lowest = price;
		}
		return lowest;
	}

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

	public static List<String> getGameNamesFromWishList(String url) throws IOException {

		List<String> results = new ArrayList<String>();
		Document userUrl = Jsoup.connect(url).get();

		for (Element row : userUrl.select(".wishlistRow")) {
			final String title = row.select("h4").text();
			results.add(title);
		}

		return results;
	}

	public static List<String> getGameNames(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

}
