import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.exceptions.SteamApiException;

public class Game_Retriever extends Thread implements Runnable {
	private Thread t;
	private List<String> gameNames;
	private String threadName;
	private List<SteamApp> steamGames;
	
	public Game_Retriever(String name, List<String> gameNames) {
		this.threadName = name;
		this.gameNames = gameNames;
		this.steamGames = new ArrayList<SteamApp>();
	}

	@Override
	public void run() {
		System.out.println("Running Thread: " + threadName);
		SteamApi steam = new SteamApi("US");
		try {
			for (String name : gameNames) {
				steamGames.add(steam.retrieve(name));
			}
		} catch (SteamApiException e1) {
			e1.printStackTrace();
		}
		System.out.println("finished " + threadName);
	}

	public List<SteamApp> getSteamGames(){
		return steamGames;
	}
}
