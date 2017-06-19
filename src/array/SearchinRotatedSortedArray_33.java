package array;


/**
 * @author rale
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray_33 {

	public int search(int[] nums, int target){ 
		int left = 0;
		int right = nums.length - 1;
		while(left<=right){
			if(nums[left]==target){
				return left;
			}
			if(nums[right] == target){
				return right;
			}
			left++;
			right--;
		}
		return -1;
    }
	
	//binary search log2n
	public int search2(int[] nums, int target){ 
		int left = 0;
		int right = nums.length - 1;
		while(left<=right){
			int mid = (left + right)/2;
			int midNum = nums[mid];
			if(midNum==target){
				return mid;
			}
			if(nums[left]<=midNum){
				if(nums[left]<=target && midNum>target){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			if (midNum <= nums[right]){
                if (target > midNum && target <= nums[right])
                    left = mid + 1;
                 else
                    right = mid - 1;
            }
		}
		return -1;
    }
	
	public static void main(String[] args){
		SearchinRotatedSortedArray_33 s = new SearchinRotatedSortedArray_33();
		System.out.println(s.search(new int[]{7,8,9,10, 0,1,2,3}, 8));
	}
}
