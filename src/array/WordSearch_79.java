package array;

/**
 * @author rale
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch_79 {
	
	//效率很低啊 扎心
	public boolean exist(char[][] board, String word) {
		if(board.length==0 || board[0].length==0 || word==null || word.isEmpty()){
			return false;
		}
		char[] wordArray = word.toCharArray();
		int row = board.length;
		int column = board[0].length;
		for(int i = 0 ; i<row ; i++){
			for(int j = 0 ; j<column ; j++){
				if(exist(board, new boolean[row][column], wordArray, 0, i, j)){
					return true;
				}
			}
		}
		return false;
    }
	
	public boolean exist(char[][] board, boolean[][] boardSelected, char[] wordArray, int index, int row, int column){
		if(boardSelected[row][column] || wordArray[index]!=board[row][column]){
			return false;
		}
        if(index==wordArray.length-1){
			return true;
		}
		boardSelected[row][column] = true;
		index++;
		if(column>0 && exist(board, boardSelected, wordArray, index, row, column-1)){
			return true;
		}
		if(column<board[0].length-1 && exist(board, boardSelected, wordArray, index, row, column+1)){
			return true;
		}
		if(row>0 && exist(board, boardSelected, wordArray, index, row-1, column)){
			return true;
		}
		if(row<board.length-1 && exist(board, boardSelected, wordArray, index, row+1, column)){
			return true;
		}
		boardSelected[row][column] = false;
		return false;
	}
	
	public boolean exist2(char[][] board, String word) {
		if(board.length==0 || board[0].length==0 || word==null || word.isEmpty()){
			return false;
		}
		char[] wordArray = word.toCharArray();
		int row = board.length;
		int column = board[0].length;
		for(int i = 0 ; i<row ; i++){
			for(int j = 0 ; j<column ; j++){
				if(exist2(board, wordArray, 0, i, j)){
					return true;
				}
			}
		}
		return false;
    }
	
	public boolean exist2(char[][] board, char[] wordArray, int index, int row, int column){
		if(wordArray[index]!=board[row][column]){
			return false;
		}
        if(index==wordArray.length-1){
			return true;
		}
        board[row][column] ^= 256;
//        board[row][column] = '*';
		index++;
		if(column>0 && exist2(board, wordArray, index, row, column-1)){
			return true;
		}
		if(column<board[0].length-1 && exist2(board, wordArray, index, row, column+1)){
			return true;
		}
		if(row>0 && exist2(board,  wordArray, index, row-1, column)){
			return true;
		}
		if(row<board.length-1 && exist2(board, wordArray, index, row+1, column)){
			return true;
		}
		board[row][column] ^= 256;
//		board[row][column] = wordArray[index-1];
		return false;
	}
}
