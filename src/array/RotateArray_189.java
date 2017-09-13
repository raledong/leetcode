package array;

/**
 * @author rale
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray_189 {
	/**
	 * 空间换时间，获得一份原数组的拷贝并且依次移动
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
        k %=nums.length;
        if(k==0) return;
        int length = nums.length;
        int[] nums2 = nums.clone();
        for(int i = 0 ; i<length ; i++){
        	nums[(i+k)%length] = nums2[i];
        }
        
    }
	
	/**
	 * 二次翻转 将其对应为出队入队的操作
	 * @param nums
	 * @param k
	 */
	public void rotate2(int[] nums, int k){
		int length = nums.length;
		k %= length;
		reverse(nums, 0, length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, length-1);
	}
	
	public void reverse(int[] nums, int start, int end){
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		
	}
	
	public static void main(String[] args){
		RotateArray_189 r = new RotateArray_189();
		r.rotate2(new int[]{1,2,3}, 2);
	}
}
