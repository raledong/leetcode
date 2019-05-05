package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedinanArray_448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        while(index < nums.length) {
        	if(nums[index] == nums[nums[index]-1]) {
        		nums[nums[index]-1] = nums[index];
        		index++;
        	}else{
        		int tmp = nums[index];
        		nums[index] = nums[tmp-1];
        		nums[tmp-1] = tmp;
        	}
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] != i+1) {
        		result.add(i+1);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		FindAllNumbersDisappearedinanArray_448 f = new FindAllNumbersDisappearedinanArray_448();
		f.findDisappearedNumbers(new int[]{
				4,3,2,7,8,2,3,1
		});
	}
}
