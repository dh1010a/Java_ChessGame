import java.awt.event.*;
import javax.swing.*;

public class BoardButton extends JButton implements ActionListener{
	private ChessBoard board;
	private ChessFrame frame;
	private final int row;
    private final int col;
	public BoardButton(ChessBoard b,ChessFrame f, int row, int col) {
		board = b;
		frame = f;
		this.row = row;
	    this.col = col;
		addActionListener(this); 
	}
	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (board.get_BoardPiece(row, col).get_type() != "")
			board.cal_road(row, col);
	}
	
}
