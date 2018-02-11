package other;

/**
 * @author rale
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * For example,
 * Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class Searcha2DMatrixII_240 {
	int column = 0;
	int row = 0;
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length == 0) return false;
        row = matrix.length;
        column = matrix[0].length;
        
        return searchMatrix2(matrix, target, 0, 0, row-1, column-1);
    }
	
	
	//超时
	public boolean searchMatrix(int rowIndex, int columnIndex, int target, int[][] matrix){
		if(rowIndex>=row || columnIndex>=column)return false;
		if(matrix[rowIndex][columnIndex] > target) return false;
		else if(matrix[rowIndex][columnIndex] == target) return true;
		return searchMatrix(rowIndex+1, columnIndex, target, matrix) || searchMatrix(rowIndex, columnIndex+1, target, matrix);
	}
	
	//二分法
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix==null || matrix.length == 0) return false;
        row = matrix.length;
        column = matrix[0].length;
        
        
        return searchMatrix(0, 0, target, matrix);
    }

	public boolean searchMatrix2(int[][] matrix, int target, int leftRow, int leftColumn, int rightRow, int rightColumn){
		if(leftRow==rightRow && leftColumn==rightColumn) return matrix[leftRow][leftColumn] == target;
		else if(leftRow > rightRow || leftColumn > rightColumn) return false;
		else if(target < matrix[leftRow][leftColumn] || target > matrix[rightRow][rightColumn]) return false;
		int midRow = (leftRow + rightRow) / 2;
		int midColumn = (leftColumn + rightColumn )/2;
		int midValue = matrix[midRow][midColumn];
		if(midValue == target) return true;
		else if(target < midValue){
			return searchMatrix2(matrix, target, leftRow, leftColumn, midRow-1, rightColumn) 
					|| searchMatrix2(matrix, target, midRow, leftColumn, rightRow, midColumn-1) ;
		}else{
			return searchMatrix2(matrix, target, leftRow, midColumn+1, rightRow, rightColumn)
					|| searchMatrix2(matrix, target, midRow+1, leftColumn, rightRow, midColumn);
		}
	}
	
	
	//第一个方法的循环版本
	public boolean searchMatrix3(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		Searcha2DMatrixII_240 s = new Searcha2DMatrixII_240();
		s.searchMatrix(new int[][]{
			{1,1}
		}, 2);
	}
}
