
public class GameOnSaleFactory extends GameFactory{
	@Override
	protected Game makeGame(String title, Double cost, Double sale, Integer priority) {
		return new GameOnSale(title, cost, sale, priority);
	}

}
