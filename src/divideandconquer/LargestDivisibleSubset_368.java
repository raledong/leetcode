package divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given a set of distinct positive integers, 
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LargestDivisibleSubset_368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.sort(nums);
        int maxIndex = -1;
        int max = 0;
        for(int i = 0 ; i<nums.length ; i++) {
        	count[i] = 1;
        	pre[i] = -1;
        	for(int j = i-1 ; j>=0 ; j--) {
        		if(nums[i] % nums[j] == 0 && count[j] >= count[i]){
        			count[i] = count[j] + 1;
        			pre[i] = j;
        		}
        	}
        	if(count[i] > max) {
        		max = count[i];
        		maxIndex = i;
        	}
        }
        
        List<Integer> result = new ArrayList<Integer>();
        while(maxIndex != -1){
        	result.add(nums[maxIndex]);
        	maxIndex = pre[maxIndex];
        }
        return result;
    }
}
