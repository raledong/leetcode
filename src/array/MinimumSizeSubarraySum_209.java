package array;

/**
 * @author rale
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray 
 * of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum_209 {
	
	public int minSubArrayLen(int s, int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int pointer1 = 0;
		int pointer2 = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(pointer2 < nums.length){
			sum += nums[pointer2];
			while(sum > s){
				min = Math.min(min, pointer2-pointer1 + 1);
				sum -= nums[pointer1++];
			}
		}
		return min==Integer.MAX_VALUE?0:min;
    }
	
}
