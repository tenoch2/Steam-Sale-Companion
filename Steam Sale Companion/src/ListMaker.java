import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.xml.transform.TransformerException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.xml.sax.SAXException;

public class ListMaker {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException,
			XPathExpressionException, TransformerException {

		ArrayList<Game> games = new ArrayList<Game>();

		for (Game game : games) {
			System.out.println(game.getTitle() + ", cost: " + game.getCost() + ", sale: " + game.getSale()
					+ ", personal priority: " + game.getPriority());
		}

		System.out.println("");

		List<Game> results = scoreGames(games);
		int listNum = 1;
		for (Game game : results) {
			System.out.println(listNum + ": " + game.getTitle() + ", score: " + game.getScore());
			listNum++;
		}

	}

	public static List<Game> scoreGames(ArrayList<Game> games) {

		List<Game> gameResults = new ArrayList<Game>();	

		int costRate = 40;
		int saleRate = 40;
		int priorityRate = 20;

		System.out
				.println("cost rate : " + costRate + ", sale Rate : " + saleRate + ", priority rate : " + priorityRate);

		generateScores(gameResults, games, costRate, saleRate, priorityRate);
		
		Collections.sort(gameResults, Collections.reverseOrder());
		return gameResults;
	}

	private static void generateScores(List<Game> results, List<Game> games, int costRate, int saleRate, int priorityRate){
		int priceWeight;
		int priorityWeight;
		int saleWeight;
		double lowestPrice = getLowestCost(games);
		GameListingFactory gameListings = new GameListingFactory();	
		for (Game game : games) {

			priceWeight = (int) (Math.sqrt(lowestPrice / game.getCost()) * costRate);
			saleWeight = (int) (game.getSale() * saleRate);
			priorityWeight = priorityRate / game.getPriority();

			int score = priceWeight + saleWeight + priorityWeight;
			Game gameToList = gameListings.enListGame(game.getTitle(), game.getCost(), game.getSale(),
					game.getPriority());
			gameToList.setScore(score);
			
			results.add(gameToList);
		}
	}
	private static double getLowestCost(List<Game> games) {
		double lowest = Integer.MAX_VALUE;
		for (Game game : games) {
			if (game.getCost() < lowest)
				lowest = game.getCost();
		}
		return lowest;

	}

}
