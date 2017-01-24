import com.github.goive.steamapi.data.SteamApp;

public abstract class GameFactory {
	
	public SteamApp enlistGame(String title, Double cost, double d, Integer priority){
		SteamApp game;
		game = makeGame(title, cost, d, priority);
		return game;
	}
	
	protected abstract SteamApp makeGame(String title, Double cost, double d, Integer priority);

	protected GameListing makeGame(String title, Double cost, Double sale, Integer priority) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
