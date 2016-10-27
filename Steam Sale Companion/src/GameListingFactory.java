
public class GameListingFactory extends GameFactory{

	@Override
	protected GameListing enlistGame(String title, Double cost, Double sale, Integer priority) {
		return new GameListing(title,cost,sale, priority);
	}


}
