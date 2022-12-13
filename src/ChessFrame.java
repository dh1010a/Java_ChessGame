import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	ImageIcon img11 = new ImageIcon("./img/horse2.png");
	Image im11 = img11.getImage();
	Image updateImg11 = im11.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Knights2 = new ImageIcon(updateImg11);
	ImageIcon img22 = new ImageIcon("./img/lock2.png");
	Image im22 = img22.getImage();
	Image updateImg22 = im22.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Rooks2 = new ImageIcon(updateImg22);
	ImageIcon img33 = new ImageIcon("./img/porn2.png");
	Image im33 = img33.getImage();
	Image updateImg33 = im33.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Pawns2 = new ImageIcon(updateImg33);
	ImageIcon img44 = new ImageIcon("./img/bs2.png");
	Image im44 = img44.getImage();
	Image updateImg44 = im44.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Bishops2 = new ImageIcon(updateImg44);
	ImageIcon img55 = new ImageIcon("./img/king2.png");
	Image im55 = img55.getImage();
	Image updateImg55 = im55.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon King2 = new ImageIcon(updateImg55);
	ImageIcon img66 = new ImageIcon("./img/queen2.png");
	Image im66 = img66.getImage();
	Image updateImg66 = im66.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Queen2 = new ImageIcon(updateImg66);
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

        c.add(p,BorderLayout.CENTER);
        setTitle("Chess Game");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        update();

	}
	public void showRoad() {

		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if(board.getBoardPiece(i, j).getType() == "" || board.getBoardPiece(i, j).getType() == "road" )
					board.board[i][j].type = "";
			}
		}
		for (int i = 0;i < 56;i++) {
			System.out.println(road[i][0] + " " + road[i][1]);
			if(road[i][0] + road[i][1] > 0) {
				if(board.getBoardPiece(road[i][0], road[i][1]).getType() == "")
					board.board[road[i][0]][road[i][1]].type = "road";
			}
		}
		
	}
	public void update() {
		for (int r = 0;r < 8;r++) {
			for (int c = 0;c < 8;c++) {
				if (board.getBoardPiece(r, c).getType() == "King") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(King1);
					else 
						button_board[r][c].setIcon(King2);
				}
				else if (board.getBoardPiece(r, c).getType() == "Queen") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(Queen1);
					else 
						button_board[r][c].setIcon(Queen2);
				}
					
				else if (board.getBoardPiece(r, c).getType() == "Rooks") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(Rooks1);
					else 
						button_board[r][c].setIcon(Rooks2);
				}
				else if (board.getBoardPiece(r, c).getType() == "Bishops") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(Bishops1);
					else 
						button_board[r][c].setIcon(Bishops2);
				}
				else if (board.getBoardPiece(r, c).getType() == "Knights") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(Knights1);
					else 
						button_board[r][c].setIcon(Knights2);
				}
				else if (board.getBoardPiece(r, c).getType() == "Pawns") {
					if(board.getBoardPiece(r, c).getPlayerNum() == 1) 
						button_board[r][c].setIcon(Pawns1);
					else 
						button_board[r][c].setIcon(Pawns2);
				}
				else if (board.getBoardPiece(r, c).getType() == "road") {
					System.out.println(r);
					System.out.println(c  + " ");

					button_board[r][c].setIcon(canroad);
				}
				else if (board.getBoardPiece(r, c).getType() == "")
					button_board[r][c].setIcon(null);
			}
		}
		if(board.victory != 0) {
			int input = JOptionPane.showConfirmDialog(null, "다시 시작하시겠습니까?", "Game over",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if (input == 0) {
				board.victory = 0;
				grave.index1 = 0;
				grave.index2 = 0;
				board.createBoard();
				update();
			}
		}
	}
}
