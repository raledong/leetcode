package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix_54 {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
		 int row = matrix.length;
		 if(row == 0){
			 return new ArrayList<Integer>();
		 }
		 int column = matrix[0].length;
		 Integer[] result = new Integer[row*column];
		 
		 int prev = -1;
		 int tempRow = row;
		 int tempColumn = column;
		 for(int i = 0 ; tempRow>1&&tempColumn>1 ; i++){
			 
			 for(int j = 0 ; j<tempColumn ; j++){
				 result[prev+j+1] = matrix[i][j+i];
				 result[prev+tempRow+tempColumn-1+tempColumn-j-1] = matrix[i+tempRow-1][j+i];
			 }
			 for(int j = 1 ; j<tempRow-1 ; j++){
				 result[prev+tempColumn+j] = matrix[j+i][column-i-1];
				 result[prev+tempColumn+tempRow+tempColumn-2+tempRow-j-1] = matrix[j+i][i];
			 }
			 prev += spiralCount(tempRow, tempColumn);
			 tempRow -=2;
			 tempColumn -=2;
		 }
		 if(tempRow == 1){
			 for(int i = 0 ; i<tempColumn ; i++){
				 result[prev+i+1] = matrix[row/2][row/2+i];
			 }
		 }
		 if(tempColumn == 1){
			 for(int i = 0 ; i<tempRow ; i++){
				 result[prev+i+1] = matrix[column/2+i][column/2];
			 }
		 }
		 return Arrays.asList(result);
	 }
	 
	 private int spiralCount(int row, int column){
		 if(row<=1){
			 return column;
		 }else{
			 return (row+column)*2 - 4;
		 }
	 }
	 
	 
	 public List<Integer> spiralOrder2(int[][] matrix) {
		 List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
	 }
	 public static void main(String[] args){
		 SpiralMatrix_54 s = new SpiralMatrix_54();
		 System.out.println(s.spiralOrder(new int[][]{{1},{7},{3}}));
	 }
	 
	 
	 
	
	 
}
