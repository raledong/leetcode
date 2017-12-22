package other;

/**
 * @author rale
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber_198 {
	
	public int rob(int[] nums) {
		if(nums==null || nums.length ==0) return 0;
		//抢劫了前一个房子可以获得的最大收入
        int rob = nums[0];
        //没有抢劫前一个房子可以获得的最大收入
        int notRob = 0;
        for(int i = 1 ; i<nums.length ; i++){
        	int prevRob = rob;
        	rob = notRob + nums[i];
        	notRob = Math.max(prevRob, notRob);
        };
        return Math.max(rob, notRob);
    }

}
