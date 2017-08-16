package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author rale
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber_136 {
	
	public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i<nums.length ; i++){
        	if(set.contains(nums[i])) set.remove(nums[i]);
        	else set.add(nums[i]);
        }
        int single = 0;
        for(Iterator<Integer> i = set.iterator() ; i.hasNext() ; ) single = i.next();
        return single;
    }
	
	//sort
	public int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0 ; i<nums.length-1 ; i+=2){
			if(nums[i]!=nums[i+1]) return nums[i];
		}
		return nums[nums.length-1];
	}
	
	//bit manipulation
	public int singleNumber3(int[] nums) {
        for (int i =1; i < nums.length; i++) {
            nums[i] ^= nums[i-1];
        }
        return nums[nums.length-1];
    }
}
