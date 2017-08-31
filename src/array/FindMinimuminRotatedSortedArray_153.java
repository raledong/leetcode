package array;

/**
 * @author rale
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray_153 {
	public int findMin(int[] nums) {
		int leftPointer = 0;
        int rightPointer = nums.length-1;
        while(leftPointer<rightPointer){
        	if(nums[leftPointer]<nums[rightPointer]){
        		break;
        	}else{
        		int mid = (leftPointer + rightPointer) / 2;
        		if(nums[leftPointer]<nums[mid]){
        			leftPointer = mid+1;
        		}else if(nums[mid]<nums[rightPointer]){
        			rightPointer = mid;
        		}else{
                    leftPointer++;
                }
        		
        	}
        }
        return nums[leftPointer];
    }
}
