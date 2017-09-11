package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII_229 {
	
	public List<Integer> majorityElement(int[] nums) {
		if(nums==null || nums.length==0) return new ArrayList<Integer>();
		if(nums.length==1) return new ArrayList<Integer>(Arrays.asList(nums[0]));
		List<Integer> result = new ArrayList<Integer>();
        int count1 = 1, count2 = 1, num1 = nums[0], num2 = nums[0];
        for(int k : nums){
        	if(nums[k] == num1) count1++;
        	else if(nums[k] == num2) count2++;
        	else if(count1 == 0) {
        		num1 = k;
        		count1++;
        	}else if(count2 == 0){
        		num2 = k;
        		count2++;
        	}else{
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i<nums.length ; i++){
        	if(nums[i]==num1) count1++;
        	else if(nums[i]==num2) count2++;
        }
        if(count1>nums.length/3) result.add(num1);
        if(count2>nums.length/3) result.add(num2);
        return result;
    }
}
