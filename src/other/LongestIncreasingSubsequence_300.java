package other;

/**
 * @author rale
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence_300 {
	
	//dp思想
	//T[i]代表以nums[i]为结尾可以获得的最长的递增序列长度
	public int lengthOfLIS(int[] nums) {
		int length = nums.length;
        if(length==0) return 0;
		int T[] = new int[nums.length];
		for(int i = 1 ; i<length ; i++){
			for(int j = i-1 ; j>=0 ; j-- ){
				if(nums[j] < nums[i] && T[j] + 1 > T[i]){
					T[i] = T[j] + 1;
				}
			}
		}
		int max = 0;
		for(int cur : T){
			max = Math.max(cur, max);
		}
        return max+1;
    }
	
	public int lengthOfLIS2(int[] nums){
		int length = nums.length;
		if(length == 0) return 0;
		
		int[] tmp = new int[length];
		tmp[0] = nums[0];
		int max = 1;
		for(int i = 1 ; i<length ; i++){
			for(int j = max-1; j>=0 ; j--){
				if(j==0 && nums[i] < tmp[j]) tmp[j] = nums[i];
				else if(j == max-1 && nums[i] > tmp[j]){
					tmp[j+1] = nums[i];
					max++;
					break;
				}
				else if(nums[i] < tmp[j] && nums[i] >tmp[j-1]){
					tmp[j] = nums[i];
					break;
				} 
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		LongestIncreasingSubsequence_300 l = new LongestIncreasingSubsequence_300();
		l.lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18});
	}
}
