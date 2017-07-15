package array;

import java.util.Arrays;

/**
 * @author rale
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive_41 {

	//先排序 再比较 找到第一个大于当前positive值的即为
	public int firstMissingPositive(int[] nums) {
		int size = nums.length;
		if(size == 0) return 1;
		Arrays.sort(nums);
		int positive = 1;
		for(int i = 0 ; i<size ; i++){
			if(nums[i]<positive) continue;
			if(nums[i]>positive) return positive;
			positive++;
		}
		return positive;
		
    }
	
	//左指针 当前整数 最大整数 
	public int firstMissingPositive2(int[] nums){
		int size = nums.length;
		int positive = 1;
		int leftPointer = 0;
		int maxPositive = size;
		while(leftPointer<size){
			if(nums[leftPointer] == positive){
				leftPointer++;
				positive++;
			}
			else if(nums[leftPointer] > maxPositive || nums[leftPointer] < positive || nums[leftPointer]==nums[leftPointer+nums[leftPointer]-positive]){
				leftPointer++;
				maxPositive--;
			}else{
				int temp = nums[leftPointer];
				nums[leftPointer] = nums[leftPointer+temp-positive];
				nums[leftPointer+temp-positive] = temp;
			}
		}
		return positive;
	}
}
