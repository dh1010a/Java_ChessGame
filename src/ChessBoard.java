import javax.swing.*;

public class ChessBoard {
	public BoardPiece[][] board = new BoardPiece[8][8];
	public String[] piecename = {"King", "Queen", "Rooks", "Bishops", "Knights", "Pawns", ""};
	Player p1;
	Player p2;
	Grave grave;
	
	public ChessBoard() {
		String input = JOptionPane.showInputDialog("1번 플레이어의 이름을 입력해주세요");
		p1 = new Player(input, 1, true);
		input = JOptionPane.showInputDialog("2번 플레이어의 이름을 입력해주세요");
		p2 = new Player(input, 1, true);
		createBoard();
		
	}
	public void createBoard() {
		board[7][3]= new BoardPiece(1, piecename[0]);
		board[0][3]= new BoardPiece(2, piecename[0]);
		board[7][4]= new BoardPiece(1, piecename[1]);
		board[0][4]= new BoardPiece(2, piecename[1]);
		board[7][7]= new BoardPiece(1, piecename[2]);
		board[7][0]= new BoardPiece(1, piecename[2]);
		board[0][0]= new BoardPiece(2, piecename[2]);
		board[0][7]= new BoardPiece(2, piecename[2]);
		board[7][2]= new BoardPiece(1, piecename[3]);
		board[7][5]= new BoardPiece(1, piecename[3]);
		board[0][2]= new BoardPiece(2, piecename[3]);
		board[0][5]= new BoardPiece(2, piecename[3]);
		board[7][1]= new BoardPiece(1, piecename[4]);
		board[7][6]= new BoardPiece(1, piecename[4]);
		board[0][1]= new BoardPiece(2, piecename[4]);
		board[0][6]= new BoardPiece(2, piecename[4]);
		for (int i = 0; i < 8; i++) {
			board[1][i] = new BoardPiece(2, piecename[5]);
			board[6][i] = new BoardPiece(1, piecename[5]);
		}
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 8; j++) {
				board[2+i][j] = new BoardPiece(0, piecename[6]);
				
			}
	}
		
	public int[][] calRoad(int r, int c){
		
	}
	public BoardPiece getBoardPiece(int r, int c) {
		return board[r][c];
	}
}
