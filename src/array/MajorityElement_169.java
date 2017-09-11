package array;

import java.util.Arrays;

/**
 * @author rale
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement_169 {
	
	/**
	 * 先排序 再用O(n)的时间复杂度遍历数组找到占据主要数量的那个值
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		int index = 0;
		for(int i = 1 ; i < length ; i++){
			if(nums[i] != nums[i-1]){
				if((i-index)>length>>1){
					return nums[index];
				}
				index = i;
			}
		}
		return nums[index];
    }
	
	public int majorityElement2(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	public int majorityElement3(int[] nums) {
		int main = nums[0], count = 1;
		for(int i = 1; i<nums.length ; i++){
			if(nums[i] == main){
				count++;
			}else{
				if(count==0){
					main = nums[i];
				}else{
					count--;
				}
			}
		}
		return main;
	}
	public static void main(String[] args){
		MajorityElement_169 m = new MajorityElement_169();
		m.majorityElement(new int[]{
				3,2,3
		});
	}
	
}
