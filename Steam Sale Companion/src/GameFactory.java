
public abstract class GameFactory {
	public Game enListGame(String title, Double cost, Double sale, Integer priority){
		Game game;
		game = enlistGame(title, cost, sale, priority);
		return game;
	}
	
	protected abstract Game enlistGame(String title, Double cost, Double sale, Integer priority);

	
}
