
public class GameListing extends Game implements Comparable<GameListing>{
	int score;
	String name;
	
	public GameListing(Game game, String name){
		super(game);
		this.name = name;
	}
	
	public Integer getScore() {
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

	
	
	@Override
	public int compareTo(GameListing o){
		return score < o.score ? -1 : score > o.score ? 1 : 0;
	}

}
