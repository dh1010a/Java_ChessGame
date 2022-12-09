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
	    if ((row + col) % 2 == 0){
        	this.setBackground(Color.black);
        	System.out.println("255");
        }
        else if ((row + col) % 2 == 1){
        	this.setBackground(Color.white);
        	System.out.println("0");
        }		addActionListener(this); 
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
		
		if (board.getBoardPiece(row, col).getType() != "" && board.getBoardPiece(row, col).getPlayerNum() == board.turn) {
			frame.road = board.calRoad(row, col);
			frame.showRoad();
			frame.show = true;

		}
		else {//movepiece에 update 써줄
			if (board.getBoardPiece(row, col).getType() == "") {
				for(int i = 0;i < 56;i++) {
					if (frame.road[i][0] == row && frame.road[i][1] == col)
						board.movePiece(frame.currow,frame.curcol, row, col);
						frame.update();
				}
			}
			frame.road = new int[56][2];
		}
	} 
	  
}
