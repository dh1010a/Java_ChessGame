
public class Grave {
	BoardPiece[] p1;
	BoardPiece[] p2;
	public int index1=0;
	public int index2=0;
	
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
			p2[index2] = b;
			index2++;
		}
	}
	
}
