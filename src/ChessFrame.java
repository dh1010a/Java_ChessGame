import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import javax.swing.ImageIcon;

public class ChessFrame extends JFrame {
	private ChessBoard board;
	private BoardButton[][] button_board;
	
	public ChessFrame(ChessBoard b) {
		ImageIcon img = new ImageIcon("./img/pngwing.png");
		ImageIcon background = new ImageIcon("./img/chessboard.png");
		board = b;
        button_board = new BoardButton[8][8];
        Container c = getContentPane();
        JPanel p = new JPanel(new GridLayout(8,8)); 
        //p.drawImage(background, 0, 0, null);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                button_board[row][col] = new BoardButton(board,this, row, col); // 버튼에는 색이 안들어감,,
                p.add(button_board[row][col]);
                if ((row + col) % 2 == 0){
                    //button_board[row][col].setIcon(img);
                    button_board[row][col].setBackground(Color.black);

                    //button_board[row][col].setOpaque(false);
                    //button_board[row][col].setContentAreaFilled(false);

                	System.out.println("255");
                }
                else if ((row + col) % 2 == 1){
                	//button_board[row][col].setText("♚");
                	System.out.println("0");
                }
            }
    	}
        c.add(p,BorderLayout.CENTER);
        setTitle("Chess Game");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
