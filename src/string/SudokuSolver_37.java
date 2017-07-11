package string;

import java.util.ArrayList;

/**
 * @author rale
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver_37 {
	//方案一 不使用数据结构 直接判断
	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    //横 竖 方块
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
	
    public void solveSudoku2(char[][] board) {
    	int length = board.length;
    	//记录第i行是否出现j数字
    	boolean[][] rows = new boolean[length][length+1];
    	//第i列是否出现j数字
    	boolean[][] columns = new boolean[length][length+1];
    	//第i个小方格是否出现j数字。
    	boolean[][] squares = new boolean[length][length+1];
    	for(int i = 0 ; i < length ; i++){
    		for(int j = 0 ; j<length ; j++){
    			if(board[i][j] != '.'){
    				int value = board[i][j] - '0';
    				rows[i][value] = true;
    				columns[j][value] = true;
    				squares[i / 3 * 3 + j / 3][value] = true;
    			}
    		}
    	}
    	solveSudoku(board, 0, rows, columns, squares);
    }
    
    private boolean solveSudoku(char[][] board, int index, boolean[][] rows, boolean[][] columns, boolean[][] squares){
    	if(index == 81){
    		return true;
    	}
    	int row = index / 9;
    	int column = index % 9;
    	int square = row/3*3 + column/3;
    	if(board[row][column]=='.'){
    		for(char i = '1' ; i<='9' ; i++){
    			if(rows[row][i-'0'] || columns[i-'0'][column] || squares[square][i-'0']) continue;
    			
    			board[row][column] = i;
    			rows[row][i-'0'] = true;
    			columns[column][i-'0'] = true;
    			squares[square][i-'0'] = true;
    			if(solveSudoku(board, index+1, rows, columns, squares)){
    				return true;
    			}else{
    				board[row][column] = '.';
        			rows[row][i-'0'] = false;
        			columns[column][i-'0'] = false;
        			squares[square][i-'0'] = false;
    			}
    		}
    		return false;
    	}
    	return solveSudoku(board, index+1, rows, columns, squares);
    }
    
    private boolean solver(int idx, char[][] board, ArrayList<Integer> stack, int[] store) {
        if (idx == stack.size()) return true;
        int n = stack.get(idx);
        int y = n / 9;
        int x = n - y * 9;
        int h = y;
        int v = 9 + x;
        int b = 18 + (y / 3 * 3 + x / 3);
        int available = ~store[h] & ~store[v] & ~store[b] & 0b111111111;
        while (available > 0) {
            int bit = available & -available;
            int num = Integer.numberOfTrailingZeros(bit);
            store[h] ^= bit;
            store[v] ^= bit;
            store[b] ^= bit;
            board[y][x] = (char)(num + '1');
            if (solver(idx + 1, board, stack, store)) return true;
            store[h] ^= bit;
            store[v] ^= bit;
            store[b] ^= bit;
            // board[y][x] = '.';
            available &= available - 1;
        }
        return false;
    }
    public void solveSudoku3(char[][] board) {
        ArrayList<Integer> stack =  new ArrayList<>();
        // int[] stack = new int[81];
        int len = 0;
        int[] store = new int[27]; // 0-8 h, 9 - 17 v, 18 - 26 b
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') stack.add(i * 9 + j);
                else {
                    int h = i;
                    int v = 9 + j;
                    int b = 18 + (i / 3 * 3 + j / 3);
                    store[h] ^= 1 << board[i][j] - '1';
                    store[v] ^= 1 << board[i][j] - '1';
                    store[b] ^= 1 << board[i][j] - '1';
                }
            }
        }
        solver(0, board, stack, store);
    }
	public static void main(String[] args){
		SudokuSolver_37 s = new SudokuSolver_37();
		char[][] board = new char[9][9];
		board[0] = "..9748...".toCharArray();
		board[1] = "7........".toCharArray();
		board[2] = ".2.1.9...".toCharArray();
		board[3] = "..7...24.".toCharArray();
		board[4] = ".64.1.59.".toCharArray();
		board[5] = ".98...3..".toCharArray();
		board[6] = "...8.3.2.".toCharArray();
		board[7] = "........6".toCharArray();
		board[8] = "...2759..".toCharArray();
 		s.solveSudoku2(board);
	}
	
}
