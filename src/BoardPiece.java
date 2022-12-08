public class BoardPiece {
	int player;
	String type;
	
	public BoardPiece(int p, String s) {
		player = p;
		type = s;
	}
	
	public int get_playernum() {
		return player;
	}
	public String get_type() {
		return type;
	}
}
