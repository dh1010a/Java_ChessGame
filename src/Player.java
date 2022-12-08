
public class Player {
	private int num;
	public boolean turn;
	private String name;
	
	public Player(String x, int n, boolean b){
		name = x;
		num = n;
		turn = b;
	}
	
	public boolean is_turn() {
		return turn;
	}
	public String get_name() {
		return name;
	}
}
