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
	    addActionListener(this); 
	}
	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println(frame.show);
		//System.out.println(board.getBoardPiece(row, col).getType());

		if (board.getBoardPiece(row, col).getType() != "" && board.getBoardPiece(row, col).getPlayerNum() == board.turn) {
			for(int i = 0;i < 8;i++) {
				for(int j = 0;j < 8;j++) {
					if(board.getBoardPiece(i, j).getType() == "" || board.getBoardPiece(i, j).getType() == "road" )
						board.board[i][j].type = "";
				}
			}
			frame.road = board.calRoad(row, col);
			frame.showRoad();
			frame.show = true;
			frame.currow = row;
			frame.curcol = col;
		}
		if (frame.show == true && (board.getBoardPiece(row, col).getType() != "" || board.getBoardPiece(row, col).getPlayerNum() != board.turn)) {
			for(int i = 0;i < 56;i++) {
				if (frame.road[i][0] == row && frame.road[i][1] == col) {
					board.movePiece(frame.currow,frame.curcol, row, col);
					frame.show = false;
					frame.update();
				}
					
			}
		}
		frame.update();
	
	} 
	  
}
