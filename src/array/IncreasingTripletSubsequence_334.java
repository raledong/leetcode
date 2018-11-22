package array;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5]
 * Output: true
 * 
 * Example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 * @author rale
 *
 */
public class IncreasingTripletSubsequence_334 {
	
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3) return false;
		
		boolean[] hasLeftMin = new boolean[nums.length];
		boolean[] hasRightMax = new boolean[nums.length];
		
		int left = 0;
		int right = nums.length - 1;
		for(int i = 1 ; i<nums.length-1 ; i++) {
			if(nums[i] > nums[left]) {
				hasLeftMin[i] = true;
			} else {
				left = i;
			}
			if(nums[nums.length - i - 1] < nums[right]) {
				hasRightMax[nums.length - i - 1] = true;
			} else {
				right = nums.length - i - 1;
			}
		}
		
		for(int i = 1 ; i < nums.length - 1 ; i++) {
			if(hasLeftMin[i] && hasRightMax[i]) return true;
		}
		return false;
    }
	
	public boolean increasingTriplet2(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for(int n : nums) {
			if(n <= small) {
				small = n;
			} else if (n<=big) {
				big = n;
			} else {
				return true;
			}
		}
		return false;
	} 
	public static void main(String[] args) {
		IncreasingTripletSubsequence_334 i = new IncreasingTripletSubsequence_334();
		i.increasingTriplet(new int[]{0,4,2,1,0,-1,-3});
	}
}
