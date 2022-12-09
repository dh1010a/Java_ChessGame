
public class Player {
	public int num;
	public boolean turn;
	private String name;
	
	public Player(String x, int n, boolean b){
		name = x;
		num = n;
		turn = b;
	}
	
	public boolean isTurn() {
		return turn;
	}
	public String getName() {
		return name;
	}
}
