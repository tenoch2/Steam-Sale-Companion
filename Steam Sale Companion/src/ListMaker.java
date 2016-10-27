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

	private static List<Game> scoreGames(ArrayList<Game> games) {
		
		List<Game> gameResults = new ArrayList<Game>();
		GameListingFactory gameListings = new GameListingFactory();
		
		
		double lowestPrice = getLowestCost(games);
		

		
		int priceWeight;
		int priorityWeight;
		int saleWeight;

		int costRate = 40;
		int saleRate = 40;
		int priorityRate = 20;

		System.out.println("cost rate : " + costRate + ", sale Rate : " + saleRate + ", priority rate : " + priorityRate);

		for (Game game : games) {
			
			priceWeight = (int) (Math.sqrt(lowestPrice / game.getCost()) * costRate);
			saleWeight = (int) (game.getSale() * saleRate);
			priorityWeight = priorityRate / game.getPriority();

			
			int score = priceWeight + saleWeight + priorityWeight;
			Game gameToList = gameListings.enListGame(game.getTitle(), game.getCost(), game.getSale(), game.getPriority());
			gameToList.setScore(score);
			gameResults.add(gameToList);
		}

		Collections.sort(gameResults, Collections.reverseOrder());
		return gameResults;
	}
	
	private static double getLowestCost(List<Game> games){
		double lowest = (double)Integer.MAX_VALUE;
		for (Game game : games) {
			if (game.getCost() < lowest)
				lowest = game.getCost();
		}
		return lowest;
		
				
	}

}
