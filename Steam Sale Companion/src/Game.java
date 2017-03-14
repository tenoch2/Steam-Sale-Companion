import com.github.goive.steamapi.data.SteamApp;

//plain jane data structure class
public class Game {
	SteamApp steamGame;
	double score;
	
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
	
	
}