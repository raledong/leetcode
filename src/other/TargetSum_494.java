package other;


/**
 * @author rale
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * 
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum_494 {

	//dfs
	public int findTargetSumWays(int[] nums, int S) {
		return findTargetSumWays(nums, 0, S);
    }
	
	public int findTargetSumWays(int[] nums, int start, int S){
		if(start==nums.length){
			if(S == 0){
				return 1;
			}else{
				return 0;
			}
		}
		int count = 0;
		count += findTargetSumWays(nums, start+1, S-nums[start+1]);
		count += findTargetSumWays(nums, start+1, S+nums[start+1]);
		return count;
		
	}
	
	
	//dp
	public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i]);
        }
        //数组中所有的值的和小于标准值 或是奇偶性不同 则直接返回
        return  sum < S || (sum + S) % 2 == 1 ? 0 : helper(nums, (sum + S) / 2);
    }
    private int helper(int[] nums, int sum) {
    	//array[i]是指和为i的集合有多少个
        int[] array = new int[sum + 1];
        array[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j - nums[i] >= 0; j--) {
                array[j] += array[j - nums[i]];
            }
        }
        return array[sum];
    }
}
