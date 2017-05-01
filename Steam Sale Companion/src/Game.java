import java.text.DecimalFormat;

import com.github.goive.steamapi.data.SteamApp;

//plain jane data structure class
public class Game {
    //creates a SteamApp object steamGame and the score value
    SteamApp steamGame;
    double score;

    /**
     * Creates a Game object and initializes steamGame
     * and score with the provided parameters
     * @param steamGame
     * @param score 
     */
    public Game(SteamApp steamGame, double score) {
            this.steamGame = steamGame;
            this.score = score;
    }

    /**
     * returns the SteamApp steamGame
     * @return 
     */
    public SteamApp getSteamGame() {
            return steamGame;
    }

    /**
     * sets steamGame to the provided parameter
     * @param steamGame 
     */
    public void setSteamGame(SteamApp steamGame) {
            this.steamGame = steamGame;
    }

    /**
     * returns the score value of the Game
     * @return 
     */
    public double getScore() {
    	
            return score;
    }

    /**
     * sets the score of the Game to the provided parameter
     * @param score 
     */
    public void setScore(double score) {
            this.score = score;
	}
	
	
}