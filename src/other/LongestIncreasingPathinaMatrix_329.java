package other;

/**
 * @author rale
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathinaMatrix_329 {
	
	int max = 1;
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length == 0) return 0;
		int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i<matrix.length ; i++){
        	for(int j = 0 ; j<matrix[0].length ; j++){
        		max = Math.max(longestIncreasingPath(matrix, i, j, cache), max);
        	}
        }
        return max;
    }
	
	public int longestIncreasingPath(int[][] matrix, int i, int j, int[][] cache){
		if(cache[i][j] > 0) return cache[i][j];
		int max = 1;
		int cur = matrix[i][j];
		if(i>0 && matrix[i-1][j] > cur){
			max = Math.max(max, longestIncreasingPath(matrix, i-1, j, cache) + 1);
		}
		if(i<matrix.length-1 && matrix[i+1][j] > cur){
			max = Math.max(max, longestIncreasingPath(matrix, i+1, j, cache) + 1);
		}
		if(j>0 && matrix[i][j-1] > cur){
			max = Math.max(max, longestIncreasingPath(matrix, i, j-1, cache) + 1);
		}
		if(j<matrix[0].length-1 && matrix[i][j+1] > cur){
			max = Math.max(max, longestIncreasingPath(matrix, i, j+1, cache) + 1);
		}
		cache[i][j] = max;
		return max;
	}
}
