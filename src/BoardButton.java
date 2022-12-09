import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

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
	    this.setBackground(Color.blue);
		addActionListener(this); 
	}
	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
	
	/*public void setcolor(int r, int c){
		if ((r + c) % 2 == 0){
        	this.setBackground(Color.black);
        	System.out.println("255");
        }
        else if ((r + c) % 2 == 1){
        	this.setBackground(new Color(100, 0, 0));
        	System.out.println("0");
        }
	}*/
	public void actionPerformed(ActionEvent e) {
		if (board.getBoardPiece(row, col).getType() != "")
			board.calRoad(row, col);
	}
	
}
