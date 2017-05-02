import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.github.goive.steamapi.data.SteamApp;

public class ListMaker {
	private List<SteamApp> apps;

	public ListMaker(List<SteamApp> apps) {
		super();
		this.apps = apps;
	}

	public List<SteamApp> getApps() {
		return apps;
	}
	
	public static List<Game> generateScores(List<SteamApp> games, double priceRate, double saleRate,
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
			else //this catches free games that would originally break program
				priceWeight = priceRate;

			double salePercent = game.getPriceDiscountPercentage();
			saleWeight = (salePercent / (double) 100 * saleRate);

			if (game.getMetacriticScore() != null)
				reviewWeight = (Math.sqrt((Math.sqrt((highestScore / (double) game.getMetacriticScore())))))
						* reviewRate;
			else //not every game has Metacritic score. Main reason we are working on implementing user review scores for now.
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
		
	
	
}
