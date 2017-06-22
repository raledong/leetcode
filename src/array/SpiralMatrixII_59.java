package array;

/**
 * @author rale
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII_59 {

	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        
        int number = 1;
        while(rowStart<=rowEnd && colStart<=colEnd){
        	for(int i = colStart ; i<=colEnd ; i++){
        		result[rowStart][i] = number;
        		number++;
        	}
        	
        	rowStart++;
        	
        	for(int i = rowStart ; i<=rowEnd ; i++){
        		result[i][colEnd] = number;
        		number++;
        	}
        	colEnd--;
        	
        	if(rowStart <= rowEnd){
        		for(int i = colEnd ; i>=colStart ; i--){
        			result[rowEnd][i] = number;
        			number++;
        		}
        	}
        	rowEnd--;
        	
        	if(colStart<= colEnd){
        		for(int i = rowEnd ; i>= rowStart ; i--){
        			result[i][colStart] = number;
        			number++;
        		}
        	}
        	colStart++;
        }
        return result;
    }
	
	public static void main(String[] args){
		SpiralMatrixII_59 s = new SpiralMatrixII_59();
		s.generateMatrix(2);
	}
}
