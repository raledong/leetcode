package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow_417 {
	
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
		int rows = matrix.length;
	    int columns = matrix[0].length;
	    //能够流入太平洋
        boolean[][] canReachPacific = new boolean[matrix.length][matrix[0].length];
        //能够流入大西洋
        boolean[][] canReachAtlantic = new boolean[matrix.length][matrix[0].length];
        for(int i = 0 ; i<rows ; i++) {
        	//以左侧边为起点寻找可以流入太平洋的所有节点
        	dfs(matrix, canReachPacific, i, 0);
        	//以右侧边为起点寻找可以流入大西洋的所有节点
        	dfs(matrix, canReachAtlantic, i, matrix[0].length-1);
        }
        
        for(int i = 0 ; i<columns ; i++) {
        	//以上侧边为起点寻找可以流入太平的所有节点
        	dfs(matrix, canReachPacific, 0, i);
        	//以下侧边为起点寻找可以流入大西洋的所有节点
        	dfs(matrix, canReachAtlantic, matrix.length-1,  i);
        }
        
        for(int i = 0 ; i<rows ; i++) {
        	for(int j = 0 ; j<columns ; j++) {
        		//将即可以流入太平洋也可以流入大西洋的水域加入结果集
        		if(canReachPacific[i][j] && canReachAtlantic[i][j]) {
        			result.add(new int[]{
        					i, j
        			});
        		}
        	}
        }
        return result;
    }
	
	public void dfs(int[][] matrix, boolean[][] canReach, int i, int j) {
		if(canReach[i][j]) return;//当前节点已经被访问过，则结束遍历
		canReach[i][j] = true;//设置为已经访问
		if(i > 0 && matrix[i-1][j] >= matrix[i][j]) dfs(matrix, canReach, i-1, j);//探索左侧高水域
		if(i < matrix.length-1 && matrix[i+1][j] >= matrix[i][j]) dfs(matrix, canReach, i+1, j);//探索右侧高水域
		if(j > 0 && matrix[i][j-1] >= matrix[i][j]) dfs(matrix, canReach, i, j-1);//探索上侧高水域
		if(j < matrix[0].length-1 && matrix[i][j+1] >= matrix[i][j]) dfs(matrix, canReach, i, j+1);//探索下侧高水域
	}
	public static void main(String[] args) {
		PacificAtlanticWaterFlow_417 p = new PacificAtlanticWaterFlow_417();
		p.pacificAtlantic(new int[][]{
			{1,2,3},
			{8,9,4},
			{7,6,5}
		});
	}
}
