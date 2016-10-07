import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;


public class ListMaker {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException{
		
		
		ArrayList<GameOnSale> games = new ArrayList<GameOnSale>();
			
		
		for(GameOnSale game : games){
			System.out.println(game.getTitle() + ", cost: " + game.getCost() + ", sale: " + 
					game.getSale() + ", personal priority: " + game.getPriority());
		}
		
		System.out.println("");
		
		List<ListOfGames> results = scoreGames(games);
		int listNum = 1;
		for(ListOfGames game : results){
			System.out.println(listNum + ": " + game.getName() + ", score: " + game.getScore());
			listNum++;
		}
		
	}
	
		public static List<ListOfGames> scoreGames(ArrayList<GameOnSale> games){
			//make an empty list
			List<ListOfGames> gameResults = new ArrayList<ListOfGames>();
			
			//find the lowest price and best sale
			double lowestPrice = 100;
			//double bestSale = .1;
			for(GameOnSale game : games){
				if ( game.getCost() < lowestPrice ) lowestPrice = game.getCost();
				//if ( game.getSale() > bestSale) bestSale = game.getSale();
				
			}
			
			//generate scores
			int priceWeight;
			int priorityWeight;
			int saleWeight;
			
			int costRate = 40;
			int saleRate = 40;
			int priorityRate = 20;
			
			System.out.println("cost rate : " + costRate + ", sale Rate : " + 
					saleRate + ", priority rate : " + priorityRate);
			
			for(GameOnSale game : games){
				//generate weights
				
				priceWeight =  (int) (Math.sqrt(lowestPrice / game.getCost()) * costRate) ;
				saleWeight = (int) (game.getSale() * saleRate) ;
				priorityWeight = priorityRate / game.getPriority() ;
				
				//add score and name to list
				int score = priceWeight + saleWeight + priorityWeight;
				gameResults.add(new ListOfGames(score, game.getTitle()));
			}
			
			Collections.sort(gameResults , Collections.reverseOrder());
			return gameResults;
		}
}
