package hashmap;

import java.util.HashSet;

/**
 * @author rale
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku_36 {
	
	public boolean isValidSudoku(char[][] board) {
		StringBuilder[] squares = new StringBuilder[]{new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder("")};
		StringBuilder[] columns = new StringBuilder[]{new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder(""),new StringBuilder("")};
		StringBuilder line;
		for(int i = 0 ; i<board.length ; i++){
			line = new StringBuilder();
			for(int j = 0 ; j<board[i].length ; j++){
				
				if(board[i][j] == '.'){
					continue;
				}
				String currentChar = board[i][j]+"";
				if(line.indexOf(currentChar) != -1){
					return false;
				}
				System.out.println(j);
				if(columns[j].indexOf(currentChar) != -1){
					return false;
				}
				int squareNum = (i/3)*3 + (j/3);
				if(squares[squareNum].indexOf(currentChar) != -1){
					return false;
				}
				line.append(currentChar);
				columns[j].append(currentChar);
				squares[squareNum].append(currentChar);
			}
		}
		return true;
    }
	
	public boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i<9; i++){
        	HashSet<Character> rows = new HashSet<Character>();
        	HashSet<Character> columns = new HashSet<Character>();
        	HashSet<Character> cube = new HashSet<Character>();
        	for (int j = 0; j < 9;j++){
        		if(board[i][j]!='.' && !rows.add(board[i][j]))
        			return false;
        		if(board[j][i]!='.' && !columns.add(board[j][i]))
        			return false;
        		int RowIndex = 3*(i/3);
        		int ColIndex = 3*(i%3);
        		if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
        			return false;
        	}
        }
        return true;
				
    }
	public static void main(String[] args){
		ValidSudoku_36 v = new ValidSudoku_36();
		char[][] test1 = new char[9][9];
		test1[0] = ".87654321".toCharArray();
		test1[1] = "2........".toCharArray();
		test1[2] = "3........".toCharArray();
		test1[3] = "4........".toCharArray();
		test1[4] = "5........".toCharArray();
		test1[5] = "6........".toCharArray();
		test1[6] = "7........".toCharArray();
		test1[7] = "8........".toCharArray();
		test1[8] = "9........".toCharArray();
		System.out.println(v.isValidSudoku(test1));
	}
}
