import javax.swing.*;

public class ChessBoard {
	public BoardPiece[][] board = new BoardPiece[8][8];
	public String[] piecename = {"King", "Queen", "Rooks", "Bishops", "Knights", "Pawns", ""};
	Player p1;
	Player p2;
	Grave grave;
	int turn = 1;
	int first = 0;
	int victory = 0;
	
	public ChessBoard() {
		String input = JOptionPane.showInputDialog("1번 플레이어의 이름을 입력해주세요");
		p1 = new Player(input, 1, true);
		input = JOptionPane.showInputDialog("2번 플레이어의 이름을 입력해주세요");
		p2 = new Player(input, 1, true);
		grave = new Grave();
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
	public boolean isPossible(int r, int c) {
		return r >= 0 && r < 8 && c >= 0 && c < 8 && board[r][c].getType().equals("") && board[r][c].getPlayerNum() == turn;
	}
	public boolean isMoveable(int r, int c) {
		return r >= 0 && r < 8 && c >= 0 && c < 8 && (board[r][c].getType().equals("") || board[r][c].getPlayerNum() != turn);
	}
		
	public int[][] calRoad(int r, int c){
		BoardPiece tmp = board[r][c];
		int idx=0;
		int[][] road = new int[56][2];
		for (int i=0;i < 56; i++)
			for(int j=0; j<2; j++)
				road[i][j] = -1;
		if (tmp.getType().equals(piecename[0])) {
			if (isMoveable(r-1, c-1)) {
				road[idx][0] = r-1;
				road[idx][1] = c-1;
				idx++;
			}
			if (isMoveable(r-1, c)) {
				road[idx][0] = r-1;
				road[idx][1] = c;
				idx++;
			}
			if (isMoveable(r-1, c+1)) {
				road[idx][0] = r-1;
				road[idx][1] = c+1;
				idx++;
			}
			if (isMoveable(r, c-1)) {
				road[idx][0] = r;
				road[idx][1] = c-1;
				idx++;
			}
			if (isMoveable(r, c+1)) {
				road[idx][0] = r;
				road[idx][1] = c+1;
				idx++;
			}
			if (isMoveable(r+1, c-1)) {
				road[idx][0] = r+1;
				road[idx][1] = c-1;
				idx++;
			}
			if (isMoveable(r+1, c)) {
				road[idx][0] = r+1;
				road[idx][1] = c;
				idx++;
			}if (isMoveable(r+1, c+1)) {
				road[idx][0] = r+1;
				road[idx][1] = c+1;
				idx++;
			}
			return road;
		}
		else if (tmp.getType().equals(piecename[4])) {
			if (isMoveable(r-2, c-1)) {
				road[idx][0] = r-2;
				road[idx][1] = c-1;
				idx++;
			}
			if (isMoveable(r-2, c+1)) {
				road[idx][0] = r-2;
				road[idx][1] = c+1;
				idx++;
			}
			if (isMoveable(r-1, c-2)) {
				road[idx][0] = r-1;
				road[idx][1] = c-2;
				idx++;
			}
			if (isMoveable(r-1, c+2)) {
				road[idx][0] = r-1;
				road[idx][1] = c+2;
				idx++;
			}
			if (isMoveable(r+2, c-1)) {
				road[idx][0] = r+2;
				road[idx][1] = c-1;
				idx++;
			}
			if (isMoveable(r+2, c+1)) {
				road[idx][0] = r+2;
				road[idx][1] = c+1;
				idx++;
			}
			if (isMoveable(r+1, c-2)) {
				road[idx][0] = r+1;
				road[idx][1] = c-2;
				idx++;
			}
			if (isMoveable(r+1, c+2)) {
				road[idx][0] = r+1;
				road[idx][1] = c+2;
				idx++;
			}
			
			return road;
		}
		else if (tmp.getType().equals(piecename[1])) {
			for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c+i)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r + i][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c-i)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r+i][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c+i)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r - i][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c-i)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r-i][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c;
	    			  idx++;
	    			  if (!board[r + i][c].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r, c+i)) {    			  
	    			  road[idx][0] = r;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c;
	    			  idx++;
	    			  if (!board[r - i][c].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r, c-i)) {    			  
	    			  road[idx][0] = r;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	      }
	      else if (tmp.getType().equals(piecename[2])) {
	    	  
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c;
	    			  System.out.println(i);
	    			  idx++;  
	    			  if (!board[r + i][c].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r, c+i)) {    			  
	    			  road[idx][0] = r;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c;
	    			  idx++;
	    			  if (!board[r - i][c].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r, c-i)) {    			  
	    			  road[idx][0] = r;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	      }
	      else if (tmp.getType().equals(piecename[3])) {
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c+i)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r + i][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r+i, c-i)) {    			  
	    			  road[idx][0] = r+i;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r+i][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c+i)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c+i;
	    			  idx++;
	    			  if (!board[r - i][c+i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	    	  for (int i = 1; i < 8; i++) {
	    		  if(isMoveable(r-i, c-i)) {    			  
	    			  road[idx][0] = r-i;
	    			  road[idx][1] = c-i;
	    			  idx++;
	    			  if (!board[r-i][c-i].getType().equals(""))
	    				  break;
	    		  }
	    		  else 
	    			  break;
	    	  }
	      }
		
		else if(tmp.getType().equals(piecename[5])) {
			int dr = 0;
			int dr2 = 0;
			idx = 0;
			if (turn == 1) {
				if (r == 6)
					dr2 = -2;
				dr = -1;				
			}
			else if (turn == 2){
				if (r == 1)
					dr2 = 2;
				dr = 1;				
			}
			if (isMoveable(r+dr, c) && board[r+dr][c].getType().equals("")) {
				road[idx][0] = r+dr;
				road[idx][1] = c;
				idx++;
			}
			if (dr2 != 0) {
				if (isMoveable(r+dr2, c) && board[r+dr2][c].getType().equals("")) {
					road[idx][0] = r+dr2;
					road[idx][1] = c;
					idx++;
				}
			}
			dr2 = 0;
			if (isMoveable(r+dr, c-1)) {
				if(!board[r+dr][c-1].getType().equals("")){
					
					road[idx][0] = r+dr;
					road[idx][1] = c-1;
					idx++;
				}
			}
			if (isMoveable(r+dr, c+1)) {
				if(!board[r+dr][c+1].getType().equals("")) {
					road[idx][0] = r+dr;
					road[idx][1] = c+1;
					idx++;					
				}
			}
		}
		return road;
	}
	
	public void changeTurn() {
		if (turn == 1) {
			turn = 2;
		}
		else if (turn == 2)
			turn = 1;
	}
	public void movePiece(int r1, int c1, int r2, int c2) {
		if (board[r2][c2].getType().equals("")) {
			board[r2][c2].type = board[r1][c1].getType();
			board[r2][c2].player = board[r1][c1].getPlayerNum();
			board[r1][c1].type = "";
			board[r1][c1].player = 0;
			
		}
		else {
			killPiece(board[r2][c2], r2, c2);
			board[r2][c2].type = board[r1][c1].getType();
			board[r2][c2].player = board[r1][c1].getPlayerNum();
			board[r1][c1].type = "";
			board[r1][c1].player = 0;
		}
		for(int i = 0;i < 8;i++) {
			for (int j = 0;j < 8;j++) {
				if(board[i][j].getType() == "road")
					board[i][j].type = "";
			}
		}
		first++;
		if (checkCheckMate(r2, c2)) {
			JOptionPane.showMessageDialog(null, "CheckMate!");
		}
		changeTurn();
		//System.out.println(turn);
	}
	public void killPiece(BoardPiece b, int r, int c) {
		if (b.getType().equals("King")) {
			gameOver(b);
		}
		grave.pushGrave(b);
	}
	public BoardPiece getBoardPiece(int r, int c) {
		return board[r][c];
	}
	public boolean checkCheckMate(int r, int c) {
		int[][] rb;
		rb = new int[56][2];
		rb = calRoad(r,c);
		for (int i = 0; i < 56; i++) {
			if(rb[i][0] >= 0 && rb[i][0] >= 0) {
				if (board[rb[i][0]][rb[i][1]].getType().equals("King")) {
					return true;
				}				
			}
			
		}
		return false;
	}
	public void gameOver(BoardPiece b) {
		if (b.getPlayerNum() == 1) {
			victory = 1;
		}
		else {
			victory = 2;
		}
		if (victory == 1)
			JOptionPane.showMessageDialog(null, p1.getName() + "님 승리하셨습니다.");
		else
			JOptionPane.showMessageDialog(null, p2.getName() + "님 승리하셨습니다.");
		p1.turn = false;
		p2.turn = true;
		turn = 2;
		}
	
}
