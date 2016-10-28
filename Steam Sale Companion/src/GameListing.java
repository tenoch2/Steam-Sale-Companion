
public class GameListing extends Game implements Comparable<GameListing>{
	int score;
	
	public GameListing(String title, Double cost, Double sale, Integer priority){
		super(title,cost,sale,priority);
	}
	
	@Override
	public Integer getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(GameListing o){
		return score < o.score ? -1 : score > o.score ? 1 : 0;
	}

}
