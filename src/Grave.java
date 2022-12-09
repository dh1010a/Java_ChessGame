
public class Grave {
	BoardPiece[] p1;
	BoardPiece[] p2;
	private int index1=0;
	private int index2=0;
	
	public Grave() {
		p1 = new BoardPiece[16];
		p2 = new BoardPiece[16];
	}
	void pushGrave(BoardPiece b) {
		if (b.getPlayerNum() == 1) {
			p1[index1] = b;
			index1++;
		}
		else {
			p1[index2] = b;
			index2++;
		}
	}
	
}
