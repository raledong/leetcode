package other;

/**
 * @author rale
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable_303 {
	
	private int[] sum;
	public RangeSumQueryImmutable_303(int[] nums) {
		this.sum = new int[nums.length];
        for(int i = 0 ; i<nums.length ; i++){
        	if(i==0) sum[i] = nums[i];
        	else{
        		sum[i] = sum[i-1] + nums[i];
        	}
        }
    }
    
    public int sumRange(int i, int j) {
    	if(i==0) return sum[j];
    	return sum[j] - sum[i-1];
    }
    
    public static void main(String[] args){
    	RangeSumQueryImmutable_303 r = new RangeSumQueryImmutable_303(new int[]{-2,0,3,-5,2,-1});
    	r.sumRange(0, 2);
    }
}
