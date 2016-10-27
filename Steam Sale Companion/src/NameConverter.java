import com.thoughtworks.xstream.converters.SingleValueConverter;

public class NameConverter implements SingleValueConverter{
	@Override
	public Object fromString(String game){
		String[] gameParts = game.split(",");
		return new GameOnSale(gameParts[0], Double.parseDouble(gameParts[1]),
				Double.parseDouble(gameParts[2]), Integer.parseInt(gameParts[3]));
	}

	@Override
	public boolean canConvert(Class type) {
		return type.equals(GameOnSale.class);
	}

	@Override
	public String toString(Object game) {
		return (((GameOnSale) game).getTitle() + ", " + ((GameOnSale) game).getCost() + ", " + 
					((GameOnSale) game).getSale() + ", " + ((GameOnSale) game).getPriority()); 
	}
}
