import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.*;


public class ChessFrame extends JFrame {
	private ChessBoard board;
	private BoardButton[][] button_board;
	
	public ChessFrame(ChessBoard b) {
		board = b;
        button_board = new BoardButton[8][8];
        Container c = getContentPane();
        JPanel p = new JPanel(new GridLayout(8,8)); 
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                button_board[row][col] = new BoardButton(board,this, row, col);
                p.add(button_board[row][col]);
            }
    	}
        c.add(p,BorderLayout.CENTER);
        setTitle("Chess Game");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
