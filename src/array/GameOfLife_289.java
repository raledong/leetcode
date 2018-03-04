package array;

/**
 * @author rale
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
 * (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife_289 {

	public void gameOfLife(int[][] board) {
       if(board==null || board.length==0) return;
       int row = board.length;
       int column = board[0].length;
       int multiply = 10;
       for(int i = 0 ; i<row ; i++){
    	   for(int j = 0 ; j<column ; j++){
    		   int cur = board[i][j];
    		   int liveNeighboars = board[i][j] / multiply;
    		   if(j+1<column && isLive(board[i][j+1])){
    			   liveNeighboars++;
    		   }
    		   if(i+1<row){
    			   if(j-1>=0 && isLive(board[i+1][j-1])){liveNeighboars++;}
    			   if(j+1<column && isLive(board[i+1][j+1])){liveNeighboars++;}
    			   if(isLive(board[i+1][j])){liveNeighboars++;}
    		   }
    		   if(isLive(cur)){
    			   if(liveNeighboars<2 || liveNeighboars>3){
    				   board[i][j] = 0;
    			   }else{
    				   board[i][j] = 1;
    			   }
    			   if(j+1<column) board[i][j+1] += multiply;
    			   if(i+1<row) board[i+1][j] += multiply;
    			   if(j-1>=0 && i+1<row) board[i+1][j-1] += multiply;
    			   if(j+1<column && i+1<row) board[i+1][j+1] += multiply;
    		   }else if(liveNeighboars==3){
    			   board[i][j] = 1;
    		   }else{
    			   board[i][j] = 0;
    		   }
    	   }
       }
    }
	
	public boolean isLive(int number){
		return number % 10 == 1;
	}
}
