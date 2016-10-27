import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("game")
public class GameOnSale extends Game {
	
	public GameOnSale(String title, Double cost, Double sale, Integer priority) {
		super(title, cost, sale, priority);
	}
	
	
	
	
	
	
}
