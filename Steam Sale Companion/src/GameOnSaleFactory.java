
public class GameOnSaleFactory extends GameFactory{

	@Override
	protected Game enlistGame(String title, Double cost, Double sale, Integer priority) {
		return new GameOnSale(title, sale, sale, priority);
	}

}
