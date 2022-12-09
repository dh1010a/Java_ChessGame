import javax.swing.*;

public class ChessBoard {
	public BoardPiece[][] board = new BoardPiece[8][8];
	public String[] piecename = {"King", "Queen", "Rooks", "Bishops", "Knights", "Pawns", ""};
	Player p1;
	Player p2;
	Grave grave;
	int turn = 1;
	int victory = 0;
	
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
				road[i][j] = 0;
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
	    	  
		  	  while(isMoveable(r + idx, c) && idx < 7) {
	    		  road[8 * idx][0] = r + idx;
	    		  road[8 * idx][1] = c;
	    		  if (!board[r + idx][c].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r - idx, c) && idx < 7) {
	    		  road[8 * idx + 1][0] = r - idx;
	    		  road[8 * idx + 1][1] = c;
	    		  if (!board[r + idx][c].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r, c + idx) && idx < 7) {
	    		  road[8 * idx + 2][0] = r;
	    		  road[8 * idx + 2][1] = c + idx;
	    		  if (!board[r + idx][c].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r, c - idx) && idx < 7) {
	    		  road[8 * idx + 3][0] = r;
	    		  road[8 * idx + 3][1] = c - idx;
	    		  if (!board[r + idx][c].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r + idx, c + idx) && idx < 7) {
	    		  road[8 * idx + 4][0] = r + idx;
	    		  road[8 * idx + 4][1] = c + idx;
	    		  if (!board[r + idx][c + idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r - idx, c + idx) && idx < 7) {
	    		  road[8 * idx + 5][0] = r - idx;
	    		  road[8 * idx + 5][1] = c + idx;
	    		  if (!board[r - idx][c + idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r + idx, c - idx) && idx < 7) {
	    		  road[8 * idx + 6][0] = r + idx;
	    		  road[8 * idx + 6][1] = c - idx;
	    		  if (!board[r + idx][c - idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r - idx, c - idx) && idx < 7) {
	    		  road[8 * idx + 7][0] = r - idx;
	    		  road[8 * idx + 7][1] = c - idx;
	    		  if (!board[r - idx][c - idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  
	      }
	      else if (tmp.getType().equals(piecename[2])) {
	    	  	  while(isMoveable(r + idx, c) && idx < 7) {
	        		  road[4 * idx][0] = r + idx;
	        		  road[4 * idx][1] = c;
	        		  if (!board[r + idx][c].getType().equals(""))
	        			  break;
	            	  idx++;  
	        	  }
	    		  idx = 0;
	    		  while(isMoveable(r - idx, c) && idx < 7) {
	        		  road[4 * idx + 1][0] = r - idx;
	        		  road[4 * idx + 1][1] = c;
	        		  if (!board[r + idx][c].getType().equals(""))
	        			  break;
	            	  idx++;  
	        	  }
	    		  idx = 0;
	    		  while(isMoveable(r, c + idx) && idx < 7) {
	        		  road[4 * idx + 2][0] = r;
	        		  road[4 * idx + 2][1] = c + idx;
	        		  if (!board[r + idx][c].getType().equals(""))
	        			  break;
	            	  idx++;  
	        	  }
	    		  idx = 0;
	    		  while(isMoveable(r, c - idx) && idx < 7) {
	        		  road[4 * idx + 3][0] = r;
	        		  road[4 * idx + 3][1] = c - idx;
	        		  if (!board[r + idx][c].getType().equals(""))
	        			  break;
	            	  idx++;  
	        	  }
	    		  idx = 0;
	      }
	      else if (tmp.getType().equals(piecename[3])) {
		  	  while(isMoveable(r + idx, c + idx) && idx < 7) {
	    		  road[4 * idx][0] = r + idx;
	    		  road[4 * idx][1] = c + idx;
	    		  if (!board[r + idx][c + idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r - idx, c + idx) && idx < 7) {
	    		  road[4 * idx + 1][0] = r - idx;
	    		  road[4 * idx + 1][1] = c + idx;
	    		  if (!board[r - idx][c + idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r + idx, c - idx) && idx < 7) {
	    		  road[4 * idx + 2][0] = r + idx;
	    		  road[4 * idx + 2][1] = c - idx;
	    		  if (!board[r + idx][c - idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
			  while(isMoveable(r - idx, c - idx) && idx < 7) {
	    		  road[4 * idx + 3][0] = r - idx;
	    		  road[4 * idx + 3][1] = c - idx;
	    		  if (!board[r - idx][c - idx].getType().equals(""))
	    			  break;
	        	  idx++;  
	    	  }
			  idx = 0;
	      }
		else if(tmp.getType().equals(piecename[5])) {
			int dr = 0;
			if (turn == 1) 
				dr = -1;
			else if (turn == 2)
				dr = 1;
			if (isMoveable(r+dr, c)) {
				road[0][0] = r+dr;
				road[0][1] = c;
				idx++;
			}
			if (isMoveable(r+dr, c-1) && !board[r+dr][c-1].getType().equals("")) {
				road[idx][0] = r+dr;
				road[idx][1] = c;
				idx++;
			}
			if (isMoveable(r+dr, c-1) && !board[r+dr][c+1].getType().equals("")) {
				road[idx][0] = r+dr;
				road[idx][1] = c+1;
				idx++;
			}
		}
		return road;
	}
	
	public void changeTurn() {
		if (turn == 1) {
			turn = 2;
		}
		else
			turn = 1;
	}
	public void movePiece(int r1, int c1, int r2, int c2) {
		if (board[r1][c1].getType().equals("")) {
			board[r2][c2] = board[r1][c1];
			board[r1][c1].refresh();
		}
		else {
			killPiece(board[r2][c2], r2, c2);
			board[r2][c2] = board[r1][c1];
			board[r1][c1].refresh();
		}
	}
	public void killPiece(BoardPiece b, int r, int c) {
		if (b.getType().equals("King")) {
			gameOver(b);
		}
		grave.pushGrave(b);
		board[r][c].refresh();
	}
	public BoardPiece getBoardPiece(int r, int c) {
		return board[r][c];
	}
	public boolean checkCheckMate(int r, int c) {
		int[][] road;
		road = calRoad(r, c);
		for (int i = 0; i < 56; i++) {
			for (int j = 0; j < 2; j++) {
				if (board[road[i][j]][road[i][j]].getType().equals("King")) {
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
	}
}
