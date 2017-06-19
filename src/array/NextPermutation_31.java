package array;

import java.util.Arrays;

/**
 * @author rale
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation_31 {
	public void nextPermutation(int[] nums) {
		for(int i = nums.length - 2 ; i>=0 ; i--){
			for(int j = i+1 ; j<nums.length ; j++){
				if(nums[i]<nums[j]){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					Arrays.sort(nums, i+1, nums.length);
					return;
				}
			}
			Arrays.sort(nums,i,nums.length);
		}
    }
	
	
	
	public static void main(String[] args){
		NextPermutation_31 n = new NextPermutation_31();
		n.nextPermutation(new int[]{2,3,1});
	}
}
