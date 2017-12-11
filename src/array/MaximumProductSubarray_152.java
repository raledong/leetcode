package array;

/**
 * @author rale
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray_152 {

	public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int i = 1, curMax = max, curMin = max ; i<nums.length ; i++){
        	if(nums[i] < 0){
        		int temp = curMax;
        		curMax = curMin;
        		curMin = temp;
        	}
        	curMax = Math.max(nums[i], curMax * nums[i]);
        	curMin = Math.min(nums[i], curMin * nums[i]);
        	
        	max = Math.max(curMax, max);
        }
        return max;
    }
}
