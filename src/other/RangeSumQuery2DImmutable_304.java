package other;

/**
 * @author rale
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DImmutable_304 {
	private int[][] sum;
	public RangeSumQuery2DImmutable_304(int[][] matrix){
		int row = matrix.length;
		if(row==0) {sum = new int[0][0]; return;}
		int column = matrix[0].length;
		sum = new int[row][column];
		
		for(int i = 0 ; i<row ; i++){
			for(int j = 0 ; j<column ; j++){
				if(i==0 && j==0) sum[i][j] = matrix[i][j];
				else if(i == 0) sum[i][j] = sum[i][j-1] + matrix[i][j];
				else if(j == 0) sum[i][j] = sum[i-1][j] + matrix[i][j];
				else{
					sum[i][j] += sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i][j];
				}
			}
		}
	}
	public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (row1>0? sum[row1-1][col2] : 0 )- (col1>0 ? sum[row2][col1-1] : 0) + (row1>0 && col1>0 ? sum[row1-1][col1-1] : 0);
    }
	
	public static void main(String[] args){
		RangeSumQuery2DImmutable_304 r = new RangeSumQuery2DImmutable_304(new int[][]{
			{-4, -5}
		});
		r.sumRegion(0, 0, 0, 0);
	}
}
