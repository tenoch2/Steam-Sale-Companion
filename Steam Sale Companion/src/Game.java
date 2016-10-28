import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("game")
public abstract class Game {
	@XStreamAlias("title")
	@XStreamAsAttribute
	private String title;
	@XStreamAlias("cost")
	@XStreamAsAttribute
	private Double cost;
	@XStreamAlias("sale")
	@XStreamAsAttribute
	private Double sale;
	@XStreamAlias("Priority")
	@XStreamAsAttribute
	private Integer priority;
	@XStreamOmitField
	private Integer score;
	
	public Game(String title, Double cost, Double sale, Integer priority){
		this.cost = cost;
		this.sale = sale;
		this.priority = priority;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getSale() {
		return sale;
	}
	public void setSale(Double sale) {
		this.sale = sale;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
