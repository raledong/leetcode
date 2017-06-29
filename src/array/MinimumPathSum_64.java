package array;

/**
 * @author rale
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum_64 {
	public int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row==0){
        	return 0;
        }
        int column = grid[0].length;
        
        for(int i = 1 ; i<row ; i++){
        	grid[i][0] += grid[i-1][0];
        }
        for(int i = 1 ; i<column ; i++){
        	grid[0][i] += grid[0][i-1];
        }
        
        for(int i = 1 ; i<row ; i++){
        	for(int j = 1 ; j<column ; j++){
        		grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        	}
        }
        return grid[row-1][column-1];
    }
}
