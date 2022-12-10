import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

public class ChessFrame extends JFrame {
	private ChessBoard board;
	private BoardButton[][] button_board;
	private Grave grave;
	public int[][] road = new int[56][2];
	public boolean show = true;
	public int currow = 0;
	public int curcol = 0;
	ImageIcon img0 = new ImageIcon("./img/road.png");
	Image im0 = img0.getImage();
	Image updateImg0 = im0.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon canroad = new ImageIcon(updateImg0);
	ImageIcon img1 = new ImageIcon("./img/horse1.png");
	Image im1 = img1.getImage();
	Image updateImg1 = im1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Knights1 = new ImageIcon(updateImg1);
	ImageIcon img2 = new ImageIcon("./img/lock1.png");
	Image im2 = img2.getImage();
	Image updateImg2 = im2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Rooks1 = new ImageIcon(updateImg2);
	ImageIcon img3 = new ImageIcon("./img/porn1.png");
	Image im3 = img3.getImage();
	Image updateImg3 = im3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Pawns1 = new ImageIcon(updateImg3);
	ImageIcon img4 = new ImageIcon("./img/bs1.png");
	Image im4 = img4.getImage();
	Image updateImg4 = im4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Bishops1 = new ImageIcon(updateImg4);
	ImageIcon img5 = new ImageIcon("./img/king1.png");
	Image im5 = img5.getImage();
	Image updateImg5 = im5.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon King1 = new ImageIcon(updateImg5);
	ImageIcon img6 = new ImageIcon("./img/queen1.png");
	Image im6 = img6.getImage();
	Image updateImg6 = im6.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Queen1 = new ImageIcon(updateImg6);
	public ChessFrame(ChessBoard b, Grave gv) {
		board = b;
		grave = gv;
		
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
        JPanel g = new JPanel(new GridLayout(2,1));
        g.setLayout(new BoxLayout(g,BoxLayout.Y_AXIS));
        
        JPanel g1 = new JPanel(new GridLayout(8,2));
        JPanel g2 = new JPanel(new GridLayout(8,2));
        /*for(int i = 0;i < 16;i++) {
        	g1.add(grave.p1[i]);
        }*/
        g.add(g1);
        g.add(g2);

        c.add(p,BorderLayout.CENTER);
        c.add(g, BorderLayout.EAST);
        setTitle("Chess Game");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        update();

	}
	int sum(int r[][]) {
		int sum = 0;
		for(int i = 0;i < 56;i++) {
			for(int j = 0;j < 2;j++) {
				if (r[i][j] != -1) {
					sum += r[i][j];
					System.out.println(r[i][j]);
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
	public void showRoad() {
		button_board[3][3].setIcon(canroad);

		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if(board.getBoardPiece(i, j).getType() == "")
					button_board[i][j].setIcon(null);
			}
		}
		for (int i = 0;i < 56;i++) {
			if(road[i][0] + road[i][1] > 0) {
				board.board[road[i][0]][road[i][1]].type = "road";
			}
		}		
	}
	public void update() {
		for (int r = 0;r < 8;r++) {
			for (int c = 0;c < 8;c++) {
				if (board.getBoardPiece(r, c).getType() == "King") {
					button_board[r][c].setIcon(King1);

					/*if(board.getBoardPiece(r, c).getPlayerNum() == 1) {
						button_board[r][c].setIcon(King1);
					}
					else {
						button_board[r][c].setIcon(King2);
					}*/
				}
				else if (board.getBoardPiece(r, c).getType() == "Queen")
					button_board[r][c].setIcon(Queen1);
				else if (board.getBoardPiece(r, c).getType() == "Rooks")
					button_board[r][c].setIcon(Rooks1);
				else if (board.getBoardPiece(r, c).getType() == "Bishops")
					button_board[r][c].setIcon(Bishops1);
				else if (board.getBoardPiece(r, c).getType() == "Knights")
					button_board[r][c].setIcon(Knights1);
				else if (board.getBoardPiece(r, c).getType() == "Pawns")
					button_board[r][c].setIcon(Pawns1);
				else if (board.getBoardPiece(r, c).getType() == "road") {
					button_board[r][c].setIcon(canroad);
				}
				else if (board.getBoardPiece(r, c).getType() == "")
					button_board[r][c].setIcon(null);
			}
		}
	}
}
