
public class GameListingFactory extends GameFactory{

	@Override
	protected GameListing makeGame(String title, Double cost, Double sale, Integer priority) {
		return new GameListing(title,cost,sale, priority);
	}


}
