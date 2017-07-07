package array;

/**
 * @author rale
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII_80 {

	public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length<=1){
        	return length;
        }
        int index = 1;
        int count = 1;
        for(int i = 1 ; i<nums.length ; i++){
        	if(nums[i] == nums[i-1]){
        		if(++count>2) continue;
        	}else{
        		count = 1;
        	}
        	nums[index++] = nums[i];
        }
        return index;
    }
	
	public int removeDuplicates2(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArrayII_80 r = new RemoveDuplicatesfromSortedArrayII_80();
		System.out.println(r.removeDuplicates(new int[]{1,1}));
	}
}
