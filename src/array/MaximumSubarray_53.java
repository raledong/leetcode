package array;

/**
 * @author rale
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray_53 {
	
	
	public int maxSubArray(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		return maxSubArray(nums, start, end);
		
        
    }
	
	public int maxSubArray(int[] nums, int start, int end){
		if(start==end){
			return nums[start];
		}
		int mid = (start + end) / 2;
		int leftMax = maxSubArray(nums, start, mid);
		int rightMax = maxSubArray(nums, mid+1, end);
		int midMax = maxMidArraySum(nums, start, end);
		return Math.max(Math.max(leftMax, rightMax), midMax);
	}
	
	public int maxMidArraySum(int[] nums, int start, int end){
		int mid = (start + end) / 2;
		
		int leftMax = Integer.MIN_VALUE;
		int temp = 0;
		do{
			temp += nums[mid];
			if(temp>leftMax){
				leftMax = temp;
			}
		}while((--mid)>=start);
		
		temp = 0;
		mid = (start + end)/2 + 1;
		int rightMax = Integer.MIN_VALUE;
		do{
			temp += nums[mid];
			if(temp>rightMax){
				rightMax = temp;
			}
		}while((++mid)<=end);
		return leftMax + rightMax;
	}
	
	public int maxMidArraySum2(int[] nums, int start, int end){
		int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
	}
}
