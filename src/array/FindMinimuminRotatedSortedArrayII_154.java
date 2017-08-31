package array;

/**
 * @author rale
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII_154 {
	
	public int findMin(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        while(leftPointer < rightPointer){
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
	
	public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int start = 0, end = nums.length - 1;
        
        //only need to add the following while loop on top of the solution 
        //for Part I
        //if two line segments have overlap, remove the overlap.
        //so, the problem can be solved as Part I
        while (nums[end] == nums[start] && end > start) {
            end--;
        }
        
        while (start < end) {
            //if the linear monotonically increasing in [start, end]
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return nums[start];
    }
}
