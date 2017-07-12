package array;

/**
 * @author rale
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * click to show follow up.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes_73 {
	
	//O(m+n)space
	public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        if(matrix.length==0){
        	return;
        }
        int columnCount = matrix[0].length;
        boolean[] rowIsZero = new boolean[rowCount];
        boolean[] columnIsZero = new boolean[columnCount];
        for(int i = 0 ; i<rowCount ; i++){
        	for(int j = 0 ; j<columnCount ; j++){
        		if(matrix[i][j]==0) {
        			rowIsZero[i] = true;
        			columnIsZero[j] = true;
        		}
        	}
        }
        
        for(int i = 0 ; i<rowCount ; i++){
        	for(int j = 0 ; j<columnCount ; j++){
        		if(rowIsZero[i] || columnIsZero[j]) {
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
	
	//O(1) space 增加了遍历次数O(n^2)
	public void setZeroes2(int[][] matrix) {
        if(matrix==null){
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        for(int i=0; i<n; i++){
            if(matrix[0][i]==0){
                rowHasZero = true;
                break;
            }
        }
        
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0){
                colHasZero = true;
                break;
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        

        
        for(int j=1;j<n; j++){
            if(matrix[0][j]==0){
                nullifyCol(matrix, j, m, n);
            }
        }
        
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0){
                nullifyRow(matrix, i, m, n);
            }
        }
        
        if(rowHasZero){
            nullifyRow(matrix, 0, m, n);
        }
        if(colHasZero){
            nullifyCol(matrix, 0, m, n);
        }
        
    }
    
    public void nullifyRow(int[][] matrix, int i, int m, int n){
        for(int col=0; col<n; col++){
            matrix[i][col] = 0;
        }
    }
    
    public void nullifyCol(int[][] matrix, int j, int m, int n){
        for(int row=0; row<m; row++){
            matrix[row][j] = 0;
        }
    }
	
}
