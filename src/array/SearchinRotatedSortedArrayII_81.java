package array;

/**
 * @author rale
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class SearchinRotatedSortedArrayII_81 {
	public boolean search(int[] nums, int target) {
		int left = 0 , right = nums.length-1;
		while(left<=right){
			int mid = ( left + right ) / 2;
			if(nums[mid] == target){
				return true;
			}else if(nums[left] < nums[mid]){
				if(target>=nums[left] && target<=nums[mid]){
					right = mid-1;
				}else{
					left = mid + 1;
				}
			}else if(nums[mid] < nums[right]){
				if(target>=nums[mid] && target<=nums[right]){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}else{
				if(nums[left] == target || nums[right] == target){
					return true;
				}else{
					left++;
					right--;
				}
			}
		}
		return false;
    }
	
	//优化一下场景
	public boolean search2(int[] nums, int target){
		int left = 0 , right = nums.length-1;
		while(left<=right){
			int mid = ( left + right ) / 2;
			if(nums[mid] == target){
				return true;
			}else if(nums[left] < nums[mid]){
				if(target>=nums[left] && target<=nums[mid]){
					right = mid-1;
				}else{
					left = mid + 1;
				}
			}else if(nums[mid] < nums[right]){
				if(target>=nums[mid] && target<=nums[right]){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			//优化一下
			}else if(nums[mid] > nums[right]){
				left = mid + 1;
			}else if(nums[mid] < nums[left]){
				right = mid - 1;
			}else{
				left++;
				right--;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		SearchinRotatedSortedArrayII_81 s = new SearchinRotatedSortedArrayII_81();
		s.search(new int[]{1,1,3,1}, 3);
	}
}
