package dynamicprogramming;

public class PredicttheWinner_486 {

	public boolean PredictTheWinner(int[] nums) {
		int[][] diff = new int[nums.length][nums.length];
		for(int i = 0 ; i<nums.length ; i++){
			diff[i][i] = nums[i];
		}
		for(int len = 1 ; len < nums.length ; len++) {
			for(int i = 0; i+len < nums.length ; i++) {
				diff[i][i+len] = Math.max(nums[i] - diff[i+1][i+len], nums[i+len] - diff[i][i+len-1]);
			}
		}
		return diff[0][nums.length-1] >= 0;
    }
	
}
