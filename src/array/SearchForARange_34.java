package array;

/**
 * @author rale
 *Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *Your algorithm's runtime complexity must be in the order of O(log n).
 *If the target is not found in the array, return [-1, -1].
 *For example,
 *Given [5, 7, 7, 8, 8, 10] and target value 8,
 *return [3, 4].
 */
public class SearchForARange_34 {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[]{-1, -1};
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int mid = (left + right)/2;
			if(nums[mid]==target){
				while(mid>=left && nums[mid]==target){
					mid--;
				}
				result[0] = mid+1;
				mid = (left + right)/2;
				while(mid<=right && nums[mid]==target){
					mid++;
				}
				result[1] = mid - 1;
				break;
			}else if (nums[mid] > target){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		return result;
    }
	
	
	public int[] searchRange2(int[] nums, int target) {
		int[] range = new int[]{nums.length, -1};
		searchRange2(nums, target, 0, nums.length, range);
		if(range[0]>range[1]) range[0]=-1;
		return range;
	}
	public void searchRange2(int[] nums, int target, int left, int right, int[] range){
		if(left>right) return;
		int mid = ( left + right ) / 2;
		if(nums[mid] == target){
			if(mid < range[0]){
				range[0] = mid;
				searchRange2(nums, target,left, mid-1, range);
			}
			if(mid > range[1]){
				range[1] = mid;
				searchRange2(nums, target, mid+1, right, range);
			}
		}else if (nums[mid]<target){
			searchRange2(nums, target, mid+1, right, range);
		}else{
			searchRange2(nums, target, left, mid-1, range);
		}
	}
	
	public int[] searchRange3(int[] nums, int target) {
	    int[] result = new int[2];
	    result[0] = findFirst(nums, target);
	    result[1] = findLast(nums, target);
	    return result;
	}

	private int findFirst(int[] nums, int target){
	    int idx = -1;
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        int mid = (start + end) / 2;
	        if(nums[mid] >= target){
	            end = mid - 1;
	        }else{
	            start = mid + 1;
	        }
	        if(nums[mid] == target) idx = mid;
	    }
	    return idx;
	}

	private int findLast(int[] nums, int target){
	    int idx = -1;
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        int mid = (start + end) / 2;
	        if(nums[mid] <= target){
	            start = mid + 1;
	        }else{
	            end = mid - 1;
	        }
	        if(nums[mid] == target) idx = mid;
	    }
	    return idx;
	}
	public static void main(String[] args){
		SearchForARange_34 s = new SearchForARange_34();
		System.out.println(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
	}
}
