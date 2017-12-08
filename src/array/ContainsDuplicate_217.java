package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate_217 {
	
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int curNum : nums){
			if(map.containsKey(curNum)) return true;
			else map.put(curNum, 1);
		}
		return false;
    }
	
	public boolean containsDuplicate2(int[] nums){
		if(nums==null || nums.length<=1) return false;
		int length = nums.length;
		int min = nums[0];
		int max = nums[0];
		for(int curNum : nums){
			if(curNum < min) min = curNum;
			if(curNum > max) max = curNum;
		}
		//如果数组中最大值和最小值之间的数字个数小于数组长度，则一定存在重复值
		if(max - min + 1< length) return true;
		
		int[] result = new int[max-min+1];
		for(int curNum : nums){
			int newIndex = curNum - min;
			if(result[newIndex] != 0) return true;
			else result[newIndex]++;
		}
		return false;
	}
}
