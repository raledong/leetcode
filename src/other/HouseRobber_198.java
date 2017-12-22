package other;

/**
 * @author rale
 *
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
