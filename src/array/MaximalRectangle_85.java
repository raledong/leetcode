package array;

import java.util.Stack;

/**
 * @author rale
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 */
public class MaximalRectangle_85 {
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0 || matrix[0].length==0) return 0;
		int row = matrix.length;
		int column = matrix[0].length;
        int[][] maxRow = new int[row][column];
        int[][] maxColumn = new int[row][column];
        int maximal = 0;
        for(int i = 0 ; i<row ; i++){
        	for(int j = 0 ; j<column ; j++){
        		if(matrix[i][j]=='1'){
        			if(i==0 && j==0){
            			maximal = maxRow[i][j] = maxColumn[i][j] = 1;
            		}else if(i==0){
            			maxRow[i][j] = maxRow[i][j-1] + 1;
            			maxColumn[i][j] = 1;
            			maximal = Math.max(maxRow[i][j], maximal);
            		}else if(j==0){
            			maxColumn[i][j] = maxColumn[i-1][j]+1;
            			maxRow[i][j] = 1;
            			maximal = Math.max(maxColumn[i][j], maximal);
            		}else{
            			maxRow[i][j] = maxRow[i][j-1] + 1;
            			maxColumn[i][j] = maxColumn[i-1][j]+1;
            			int tempMaxColumn = maxRow[i][j];
            			for(int k = 1 ; k <= maxColumn[i][j] ; k++){
            				tempMaxColumn = Math.min(maxRow[i-k+1][j], tempMaxColumn);
            				if(tempMaxColumn==1){
            					maximal = Math.max(maximal, maxColumn[i][j]);
            					break;
            				}
            				maximal = Math.max(maximal, tempMaxColumn * k);
            			}
            		}
        		}
        		
        	}
        }
        return maximal;
    }
	
	//栈
	public int maximalRectangle2(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array 
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;
        
        
        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;
                
                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
	public static void main(String[] args){
		MaximalRectangle_85 m = new MaximalRectangle_85();
		m.maximalRectangle(new char[][]{
			"10100".toCharArray(),
			"10111".toCharArray(),
			"11111".toCharArray(),
			"10010".toCharArray()
		});
	}
}
