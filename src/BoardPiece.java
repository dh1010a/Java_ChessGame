public class BoardPiece {
	int player;
	String type;
	
	public BoardPiece(int p, String s) {
		player = p;
		type = s;
	}
	
	public int getPlayerNum() {
		return player;
	}
	public String getType() {
		return type;
	}
	public void refresh() {
		player = 0;
		type = "";
	}
	
}
