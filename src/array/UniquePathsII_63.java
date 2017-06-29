package array;

/**
 * @author rale
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * 	[0,0,0],
 * 	[0,1,0],
 * 	[0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */
public class UniquePathsII_63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row==0){
        	return 0;
        }
        int column = obstacleGrid[0].length;
        
        int path = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1 ; i<row ; i++){
        	if(obstacleGrid[i][0] == 1){
        		path = 0;
        	}
        	obstacleGrid[i][0] = path;
        }
        
        path = 1;
        for(int i = 0 ; i<column ; i++){
        	if(obstacleGrid[0][i] == 1){
        		path = 0;
        	}
        	obstacleGrid[0][i] = path;
        }
        
        for(int i = 1 ; i<row ; i++){
        	for(int j = 1 ; j<column ; j++){
        		if(obstacleGrid[i][j] == 1){
        			obstacleGrid[i][j] = 0;
        		}else{
        			obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
        		}
        	}
        }
        return obstacleGrid[row-1][column-1];
    }
	
	public static void main(String[] args){
		UniquePathsII_63 u = new UniquePathsII_63();
		System.out.println(u.uniquePathsWithObstacles(new int[][]{
			{0,0,0},
			{0,1,0},
			{0,0,0}
		}));
	}

}
