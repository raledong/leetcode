package other;

/**
 * @author rale
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions_130 {
	
	 public void solve(char[][] board) {
			if(board.length<=2 || board[0].length<=2 ) return;
	        int row = board.length;
	        int column = board[0].length;
	        for(int i = 0 ; i<row ; i++){
	        	if(board[i][0] == 'O'){
	        		boundarySearch(board,i,0);
	        	}
	        	if(board[i][column-1]=='O'){
	        		boundarySearch(board, i, column-1);
	        	}
	        }
	        for(int j = 0 ; j<column ; j++){
	        	if(board[0][j] == 'O'){
	        		boundarySearch(board, 0, j);
	        	}
	        	if(board[row-1][j] == 'O'){
	        		boundarySearch(board, row-1, j);
	        	}
	        }
	        
	        for(int i = 0 ; i<row ; i++){
	        	for(int j = 0 ; j<column ; j++){
	        		if(board[i][j]=='O'){
	        			board[i][j] = 'X';
	        		}else if(board[i][j]=='*'){
	        			board[i][j] = 'O';
	        		}
	        	}
	        }
	    }
		
		public void boundarySearch(char[][] board, int i, int j){
			if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
			if(board[i][j] == 'X' || board[i][j]=='*') return;
			board[i][j] = '*';
	        if(i>1 && board[i-1][j]=='O') boundarySearch(board, i-1, j);
			if(j>1 && board[i][j-1]=='O') boundarySearch(board, i, j-1);
			if(i<board.length-2 && board[i+1][j]=='O') boundarySearch(board, i+1, j);
			if(j<board[0].length-2 && board[i][j+1]=='O') boundarySearch(board, i, j+1);
			
		}
	
}
