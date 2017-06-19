package array;

/**
 * @author rale
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage_48 {

	public void rotate(int[][] matrix) {
		int length = matrix.length;
        for(int i = 0 ; i < length/2 ; i++){
        	for(int j = i ; j<length-i-1 ; j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[length-j-1][i];
        		matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
        		matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
        		matrix[j][length-i-1] = temp;
        	}
        }
    }

	
	public static void main(String[] args){
		RotateImage_48 r = new RotateImage_48();
		r.rotate(new int[][]{{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26}, {33,1,20,7,21,7}, {4,24,1,6,32,34}});
	}
}
