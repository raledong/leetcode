package other;

/**
 * @author rale
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 */
public class MaximalSquare_221 {
	
	public int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length==0) return 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] result = new int[row+1][column+1];
		int max = 0;
		for(int i = 1 ; i<row ; i++){
			for(int j = 1 ; j<column ; j++){
				if(matrix[i-1][j-1]=='1'){
					result[i][j] = Math.min(Math.min(result[i-1][j], result[i][j-1]), result[i-1][j-1]);
					max = Math.max(result[i][j]*result[i][j], max);
				}
			}
		}
		return max;
    }
	
	public static void main(String[] args){
		MaximalSquare_221 m = new MaximalSquare_221();
		m.maximalSquare(new char[][]{
			{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
		});
	}

}
