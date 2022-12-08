import javax.swing.JFrame;

public class ChessFrame extends JFrame {
	private ChessBoard board;
	private BoardButton[][] button_board;
	
	public ChessFrame(ChessBoard b) {
		board = b;
		
	}
}
