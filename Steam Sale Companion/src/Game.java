import com.github.goive.steamapi.data.SteamApp;

public class Game {
	private SteamApp steamGame;
	private double score;
	private int userReviewScore;
	
	public Game(SteamApp steamGame, double score) {
		this.steamGame = steamGame;
		this.score = score;
	}

	public SteamApp getSteamGame() {
		return steamGame;
	}

	public void setSteamGame(SteamApp steamGame) {
		this.steamGame = steamGame;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getUserReviewScore() {
		return userReviewScore;
	}

	public void setUserReviewScore(int userReviewScore) {
		this.userReviewScore = userReviewScore;
	}
	
	
}