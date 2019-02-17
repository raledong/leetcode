package array;

import java.util.Arrays;

/**
 * @author rale
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */
public class CombinationSumIV_377 {
	
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] combinationCount = new int[target+1];
		
		combinationCount[0] = 1;
		
		for(int i = 1 ; i<=target ; i++) {
			for(int j = 0 ; j<nums.length && nums[j] <= i ; j++) {
				combinationCount[i] += combinationCount[i - nums[j]];
			}
		}
		return combinationCount[target];
    }
	
	 public int combinationSum4_2(int[] nums, int target) {
	        if (nums == null || nums.length < 1) {
	            return 0;
	        }
	        int[] dp = new int[target + 1];
	        Arrays.fill(dp, -1);
	        dp[0] = 1;
	        return helper(nums, target, dp);
	    }
	    
	    private int helper(int[] nums, int target, int[] dp) {
	        if (dp[target] != -1) {
	            return dp[target];
	        }
	        int res = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (target >= nums[i]) {
	                res += helper(nums, target - nums[i], dp);
	            }
	        }
	        dp[target] = res;
	        return res;
	    }
}
