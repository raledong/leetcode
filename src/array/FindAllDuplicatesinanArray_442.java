package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesinanArray_442 {
	public List<Integer> findDuplicates(int[] nums) {
        int index = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(index < nums.length) {
        	int num = nums[index];
        	if(num == 0){
        		index++;
        	}else if (nums[num-1] == num) {
        		if(index != num-1){
            		result.add(num);
            		nums[index] = 0;
        		}
        		index++;
        	}else{
        		swap(index, num-1, nums);
        	}
        }
        return result;
    }
	
	public void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
	
	public static void main(String[] args) {
		FindAllDuplicatesinanArray_442 f = new FindAllDuplicatesinanArray_442();
		f.findDuplicates(new int[]{
				4,3,2,7,8,2,3,1	
		});
	}
}
