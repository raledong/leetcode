package array;

import java.util.Arrays;

/**
 * @author rale
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int length = nums.length;
		int closest = nums[0]+nums[1]+nums[2] - target;
		for(int i = 0 ; i<length-2 ; ){
			for(int j = i+1, k = length-1 ; j<k ; ){
				int value = nums[i] + nums[j] + nums[k] - target;
				if(value<0){
					while(nums[j]==nums[++j] && j < k);
				}
				if(value>0){
					while(nums[k--] == nums[k] && j < k);
				}
				if(value==0){
					return target;
				}
				if(Math.abs(value) < Math.abs(closest)){
					closest = value;
				}		
			}
			while(nums[i] == nums[++i] && i < nums.length - 2);
		}
			
		return closest + target;
	}
	
}
