package array;

import java.util.List;

/**
 * @author rale
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
        if(row==0) return 0;
        for(int i = row-2 ; i>=0 ; i--){
        	for(int j = 0 ; j <= i ; j++){
        		triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
        	}
        }
        return triangle.get(0).get(0);
    }
	
	
}
