package dynamicprogramming;

/**
 * @author rale
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * Examples:
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum_410 {
	
	public int splitArray(int[] nums, int m) {
		int[] sums = new int[nums.length+1];
		for(int i = 1 ; i<=nums.length ; i++) {
			sums[i] = nums[i-1] + sums[i-1];
		}
		return splitArray(nums, m, 0, sums);
    }
	
	public int splitArray(int[] nums, int m, int cur, int[] sums) {
		if(m == 1) {
			return sums[nums.length] - sums[cur];
		}
		int min = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		for(int i = cur+1 ; i<=nums.length-m+1 ; i++) {
			int left = sums[i]-sums[cur];
			int right = splitArray(nums, m-1, i, sums);
			if(diff < Math.abs(left - right)) {
				break;
			}
			diff = Math.abs(left - right);
			min = Math.min(min, Math.max(left, right));
		}
		return min;
	}
	
	public int splitArray2(int[] nums, int m) {
		long sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<nums.length ; i++) {
			max = Math.max(max, nums[i]);
			sum += nums[i];
		}
		if(m == 1) {
			return (int)sum;
		}
		long lft = max;
		long rgt = sum;
		while(lft <= rgt) {
			long mid = (lft + rgt) / 2;
			if(valid(nums, m, mid)) {
				rgt = mid - 1;
			}else {
				lft = mid + 1;
			}
		}
		return (int) lft;
		
	}
	
	public boolean valid(int[] nums, int m, long target) {
		int count = 1;
		long sum = 0;
		for(int i = 0 ; i<nums.length ; i++) {
			sum += nums[i];
			if(sum > target) {
				sum = nums[i];
				count++;
				if(count > m) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * dp[s,j] is the solution for splitting subarray n[j]...n[L-1] into s parts.
	 * dp[s+1,i] = min{ max(dp[s,j], n[i]+...+n[j-1]) }, i+1 <= j <= L-s
	 * @param nums
	 * @param m
	 * @return
	 */
	public int splitArray3(int[] nums, int m)
	{
	    int L = nums.length;
	    int[] S = new int[L+1];
	    S[0]=0;
	    for(int i=0; i<L; i++)
	        S[i+1] = S[i]+nums[i];

	    int[] dp = new int[L];
	    for(int i=0; i<L; i++)
	        dp[i] = S[L]-S[i];

	    for(int s=1; s<m; s++)
	    {
	        for(int i=0; i<L-s; i++)
	        {
	            dp[i]=Integer.MAX_VALUE;
	            for(int j=i+1; j<=L-s; j++)
	            {
	                int t = Math.max(dp[j], S[j]-S[i]);
	                if(t<=dp[i])
	                    dp[i]=t;
	                else
	                    break;
	            }
	        }
	    }

	    return dp[0];
	}
	public static void main(String[] args) {
		SplitArrayLargestSum_410 s = new SplitArrayLargestSum_410();
		s.splitArray(new int[]{7,2,5,10,8}, 2);
	}
}
