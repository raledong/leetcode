package array;

/**
 * @author rale
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * click to show spoilers.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement_162 {
	public int findPeakElement(int[] nums) {
		if(nums.length == 1) return 0;
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        while(leftPointer < rightPointer){
        	int mid = (leftPointer + rightPointer) / 2;
        	int leftValue = mid==0?Integer.MIN_VALUE : nums[mid-1];
        	int rightValue = mid==nums.length-1 ? Integer.MIN_VALUE : nums[mid+1];
        	if(nums[mid]>=leftValue && nums[mid]>=rightValue) return mid;
        	if(nums[mid]>=leftValue && nums[mid]<=rightValue) leftPointer = mid+1;
        	else rightPointer = mid;
        }
        return leftPointer;
    }
}
