package array;

import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?


 */
public class PascalsTriangleII_119 {
	public List<Integer> getRow(int rowIndex) {
		Integer[] nums = new Integer[rowIndex+1];
        for(int i = 0 ; i<=rowIndex ; i++){
        	for(int j = 0 ; j<=i ; j++){
        		if(j==0 || j==i){
        			nums[j] = 1;
        		}else{
        			nums[rowIndex] = nums[j]+nums[0];
        			nums[0] = nums[j];
        			nums[j] = nums[rowIndex];
        		}
        	}
        }
        nums[0] = 1;
        return Arrays.asList(nums);
    }
}
