package other;

/**
 * @author rale
 * Given a matrix of M x N elements (M rows, N columns), 
 * return all elements of the matrix in diagonal order as shown in the below image.
 * 
 * Example:
 * Input:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]

Output:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse_498 {
	
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return new int[0];
		int row = matrix.length;
		int column = matrix[0].length;
		int[] result = new int[row * column];
		int rowIndex = 0;
		int columnIndex = 0;
		boolean up = true;
		int index = 0;
		while(index < result.length) {
			result[index++] = matrix[rowIndex][columnIndex];
			if(up) {
				if(rowIndex > 0 && columnIndex < column-1) {
					rowIndex--;
					columnIndex++;
				}else {
					up = false;
					if(columnIndex < column-1){
						columnIndex++;
					}else {
						rowIndex++;
					}
				}
					
			}else {
				if(rowIndex < row-1 && columnIndex > 0) {
					rowIndex++;
					columnIndex--;
				}else{
					up = true;
					if(rowIndex < row-1) {
						rowIndex++;
					}else {
						columnIndex++;
					}
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		DiagonalTraverse_498 d = new DiagonalTraverse_498();
		d.findDiagonalOrder(new int[][]{
			{1,2},
			{3,4}
		});
	}
}
