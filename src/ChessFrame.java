import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import javax.swing.ImageIcon;

public class ChessFrame extends JFrame {
	private ChessBoard board;
	private BoardButton[][] button_board;
	public int[][] road = new int[56][2];
	public boolean show = true;
	public int currow = 0;
	public int curcol = 0;
	ImageIcon img1 = new ImageIcon("./img/horse.png");
	Image im1 = img1.getImage();
	Image updateImg1 = im1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Knights = new ImageIcon(updateImg1);
	ImageIcon img2 = new ImageIcon("./img/lock.png");
	Image im2 = img2.getImage();
	Image updateImg2 = im2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Rooks = new ImageIcon(updateImg2);
	ImageIcon img3 = new ImageIcon("./img/porn.png");
	Image im3 = img3.getImage();
	Image updateImg3 = im3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Pawns = new ImageIcon(updateImg3);
	ImageIcon img4 = new ImageIcon("./img/bs.png");
	Image im4 = img4.getImage();
	Image updateImg4 = im4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Bishops = new ImageIcon(updateImg4);
	ImageIcon img5 = new ImageIcon("./img/king.png");
	Image im5 = img5.getImage();
	Image updateImg5 = im5.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon King = new ImageIcon(updateImg5);
	ImageIcon img6 = new ImageIcon("./img/queen.png");
	Image im6 = img6.getImage();
	Image updateImg6 = im6.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Queen = new ImageIcon(updateImg6);
	public ChessFrame(ChessBoard b) {
		board = b;
		
		Color color = new Color(205,133,63);
		board = b;
        button_board = new BoardButton[8][8];
        Container c = getContentPane();
        JPanel p = new JPanel(new GridLayout(8,8)); 
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                button_board[row][col] = new BoardButton(board,this, row, col); // 버튼에는 색이 안들어감,,
                if ((row + col) % 2 == 0)
                	button_board[row][col].setBackground(color);
                p.add(button_board[row][col]);
            }
    	}
        /*button_board[0][0].setIcon(lock);
        button_board[0][1].setIcon(knight);
        button_board[0][2].setIcon(bs);
        button_board[0][3].setIcon(king);
        button_board[0][4].setIcon(queen);
        button_board[0][5].setIcon(bs);
        button_board[0][6].setIcon(knight);
        button_board[0][7].setIcon(lock);
        for(int i = 0; i < 8;i++) {
        	button_board[1][i].setIcon(porn);
        }
        button_board[7][0].setIcon(lock);
        button_board[7][1].setIcon(knight);
        button_board[7][2].setIcon(bs);
        button_board[7][3].setIcon(king);
        button_board[7][4].setIcon(queen);
        button_board[7][5].setIcon(bs);
        button_board[7][6].setIcon(knight);
        button_board[7][7].setIcon(lock);
        for(int i = 0; i < 8;i++) {
        	button_board[6][i].setIcon(porn);
        }*/

        c.add(p,BorderLayout.CENTER);
        setTitle("Chess Game");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        update();

	}
	int sum(int r[][]) {
		int sum = 0;
		for(int i = 0;i < 56;i++) {
			for(int j = 0;j < 2;j++) {
				sum += r[i][j];
			}
		}
		return sum;
	}
	public void showRoad() {
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if(board.getBoardPiece(i, j).getType() == "")
					button_board[i][j].setIcon(null);
			}
		}
		if(sum(road) > 0) {
			for (int i = 0;i < 56;i++) {
				if(road[i][0] + road[i][1] > 0) {
					button_board[road[i][0]][road[i][1]].setIcon(Knights);
					//System.out.print(road[i][0] + " ");
					//System.out.print(" " +road[i][1]);

				}
			}
		}
		
	}
	public void update() {
		for (int r = 0;r < 8;r++) {
			for (int c = 0;c < 8;c++) {
				if (board.getBoardPiece(r, c).getType() == "King")
				button_board[r][c].setIcon(King);
				else if (board.getBoardPiece(r, c).getType() == "Queen")
					button_board[r][c].setIcon(Queen);
				else if (board.getBoardPiece(r, c).getType() == "Rooks")
					button_board[r][c].setIcon(Rooks);
				else if (board.getBoardPiece(r, c).getType() == "Bishops")
					button_board[r][c].setIcon(Bishops);
				else if (board.getBoardPiece(r, c).getType() == "Knights")
					button_board[r][c].setIcon(Knights);
				else if (board.getBoardPiece(r, c).getType() == "Pawns")
					button_board[r][c].setIcon(Pawns);
				else if (board.getBoardPiece(r, c).getType() == "")
					button_board[r][c].setIcon(null);
			}
		}
	}
}
