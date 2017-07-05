package array;

/**
 * @author rale
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * click to show follow up.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors_75 {
	//O(2n)
	public void sortColors1(int[] nums) {
		int numOfZero = 0;
        int numOfOne = 0;
        for(int i = 0 ; i < nums.length ; i++){
        	if(nums[i]==0){
        		numOfZero++;
        	}else if(nums[i]==1){
        		numOfOne++;
        	}
        }
        for(int i = 0 ; i<nums.length ; i++){
        	if(numOfZero>0){
        		nums[i] = 0;
        		numOfZero--;
        	}else if(numOfOne>0){
        		nums[i] = 1;
        		numOfOne--;
        	}else{
        		nums[i] = 2;
        	}
        }
    }
	
	public void sortColors2(int[] nums){
		int leftPointer = 0;
		int rightPointer = nums.length-1;
		for(int i = 0 ; i<nums.length ; i++){
			if(nums[i] == 0){
				nums[leftPointer++] = 0;
			}else if(nums[i]==2){
				nums[rightPointer--] = 2;
			}
		}
		while(leftPointer<=rightPointer){
			nums[leftPointer++] = 1;
			nums[rightPointer--] = 1;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
	//保证i前全是0，j后全是2，然后通过交换使得i和j中间确定为1,O(n)
    public void sortColors3(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int ptr = 0;
        while (ptr <= j) {
            if (nums[ptr] == 0) {
                swap(nums, i++, ptr++);
            } else if (nums[ptr] == 1) {
                ptr++;
            } else {
                swap(nums, ptr, j--);
            }
        }
    }
}
