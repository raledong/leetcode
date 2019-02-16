package reservoirsampling;

import java.util.Random;

/**
 * @author rale
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. 
 * You can assume that the given target number must exist in the array.
 * 
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * 
 * Example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class RandomPickIndex_398 {

	private int[] nums;
	private Random r;
	public RandomPickIndex_398(int[] nums) {
		this.nums = nums;
		this.r = new Random();
	}
    
    public int pick(int target) {
        int count = 0;
        int result = -1;
        for(int i = 0 ; i<nums.length ; i++) {
        	if(target == nums[i]) {
        		count++;
        	}
        }
        int index = r.nextInt(count);
        for(int i = 0 ; i<nums.length ; i++) {
        	if(target == nums[i]) {
        		index--;
                
                if(index == -1){
                	result = i;
                	break;
                }
        	}
        }
        return result;
    }
    
    public int pick2(int target) { 
    	int count = 0;
    	int result = -1;
    	for(int i = 0 ; i<nums.length ; i++) {
    		if(nums[i] == target) {
    			int index = r.nextInt(++count);
    			if(index == 0) {
    				result = i; 
    			}
    		}
    	}
    	return result;
    }
}
