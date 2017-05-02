import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

public class GameRetriever {
	private List<String> gameNames;
	private String username;
	
	public GameRetriever(String username) {
		this.username = username;
	}
	
	public List<String> getGameNames() {
		return gameNames;
	}

	public void setGameNames(List<String> gameNames) {
		this.gameNames = gameNames;
	}

	public void getGameNamesFromWishList() throws IOException, SteamCondenserException {

		List<String> results = new ArrayList<String>();
		SteamId id = SteamId.create(username);
		String url = id.getBaseUrl() + "/wishlist";
		Document userUrl = Jsoup.connect(url).get();
		
		//go through every HTML row of "wishlistRow" from the website and store it in string list
		for (Element row : userUrl.select(".wishlistRow")) {
			final String title = row.select("h4").text();
			results.add(title);
		}

		this.gameNames = results;
	}
}
