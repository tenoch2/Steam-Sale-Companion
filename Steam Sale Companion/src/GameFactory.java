
public abstract class GameFactory {
	
	public Game enlistGame(String title, Double cost, Double sale, Integer priority){
		Game game;
		game = makeGame(title, cost, sale, priority);
		return game;
	}
	
	protected abstract Game makeGame(String title, Double cost, Double sale, Integer priority);


	
}
