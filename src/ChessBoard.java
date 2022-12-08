import javax.swing.*;

public class ChessBoard {
	public BoardPiece[][] board = new BoardPiece[8][8];
	public String[] piecename = new String[6];
	Player p1;
	Player p2;
	Grave grave;
	
	public ChessBoard() {
		String input = JOptionPane.showInputDialog("1번 플레이어의 이름을 입력해주세요");
		p1 = new Player(input, 1, true);
		
	}
	public void createBoard() {
		int a;
	}
}
