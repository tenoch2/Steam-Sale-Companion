import java.util.*;
public class ListOfGames implements Comparable<ListOfGames>{
	int score;
	String name;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ListOfGames(int score, String name){
		this.score = score;
		this.name = name;
	}
	
	@Override
	public int compareTo(ListOfGames o){
		return score < o.score ? -1 : score > o.score ? 1 : 0;
	}
}
