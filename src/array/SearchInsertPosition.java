package array;

/**
 * @author rale
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        int index=0;
        for( ; index<nums.length ; index++){
        	if(nums[index]>=target){
        		break;
        	}
        }
        return index;
    }
	
	public int searchInsert2(int[] nums, int target) {
		int pointerLeft = 0;
        int pointerRight = nums.length-1;
        for( ; pointerLeft<=pointerRight ; pointerLeft++, pointerRight--){
        	if(nums[pointerLeft]>=target){
        		return pointerLeft;
        	}
        	if(nums[pointerRight]<target){
        		return pointerRight+1;
        	}
        }
        return pointerLeft;
    }
	
	
	//二分法查找
	public int searchInsert3(int[] nums, int target) {
		int pointerLeft = 0;
        int pointerRight = nums.length-1;
        while(pointerLeft<=pointerRight){
        	int mid = (pointerLeft+pointerRight)/2;
        	if(nums[mid]==target){
        		return mid;
        	}else if(nums[mid]>target){
        		pointerRight = mid-1;
        	}else{
        		pointerLeft = mid+1;
        	}
        }
        return pointerLeft;
    }
}
