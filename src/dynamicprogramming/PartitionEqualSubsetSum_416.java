package dynamicprogramming;

/**
 * @author rale
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum_416 {
	
	public boolean canParition2(int[] nums) {
		int sum = 0;
        for(int n : nums) {
        	sum += n;
        }
        if(sum % 2 != 0) return false;
        int half = sum / 2;
		boolean[][] sums = new boolean[nums.length+1][half+1];
		for(int i = 0 ; i<=nums.length ; i++) {
			for(int j = 0 ; j<=half ; j++) {
				if(i==0 && j==0){
					sums[i][j] = true;
				}else if(i==0) {
					sums[i][j] = false;
				}else if(j==0){
					sums[i][j] = true;
				}else {
					sums[i][j] = sums[i-1][j] || (nums[i-1] <= j ? sums[i-1][j-nums[i-1]] : false);
				}
			}
		}
		return sums[nums.length][half];
	}
	
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        return dfs(0, nums, sum/2);
    }
    private boolean dfs(int index, int[] nums, int target){
        if(target == 0) return true;
        if(target < 0 || index == nums.length) return false;
        if(dfs(index + 1, nums, target - nums[index])) return true;
        int j = index + 1;
        //除去重复的选择
        while(j < nums.length && nums[j] == nums[index]){
            j++;
        }
        return dfs(j, nums, target);
    }
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum_416 p = new PartitionEqualSubsetSum_416();
		p.canParition2(new int[]{1,5,11,5});
	}
	
}
