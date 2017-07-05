package array;

/**
 * @author rale
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Searcha2DMatrix_74 {
	
	//本质上还是在一维的角度上使用二分法
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
        	return false;
        }
        int column = matrix[0].length;
        if(column==0){
            return false;
        }
        
        int leftPointer = 0, rightPointer=row-1;
        
        while(leftPointer<=rightPointer){
        	int mid = (leftPointer+rightPointer) / 2;
        	if(matrix[mid][0]<=target && matrix[mid][column-1]>=target){
        		leftPointer = 0;
        		rightPointer = column-1;
        		while(leftPointer<=rightPointer){
        			int columnMid = (leftPointer + rightPointer) / 2;
        			if(matrix[mid][columnMid] == target){
        				return true;
        			}else if(matrix[mid][columnMid] < target){
        				rightPointer = columnMid-1;
        			}else{
        				leftPointer = columnMid + 1;
        			}
        		}
        		return false;
        	}else if(target<matrix[mid][0]){
        		rightPointer = mid-1;
        	}else {
        		leftPointer = mid + 1;
        	}
        }
        return false;
        
    }
	
	public boolean searchMatrix2(int[][] matrix, int target){
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return false;
		}
		int row = matrix.length;
		int column = matrix[0].length;
		int left = 0;
		int right = row*column-1;
		while(left<=right){
			int mid = (left + right) / 2;
			int tempVal = matrix[mid/column][mid%column];
			if(tempVal == target){
				return true;
			}else if(tempVal < target){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return false;
	}
}
