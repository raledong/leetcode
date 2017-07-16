package array;

/**
 * @author rale
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII_45 {
	private int minimumSteps = Integer.MAX_VALUE;

	//正向递归会超时
	public int jump(int[] nums) {
        jump(nums, 0, 0);
        return minimumSteps;
    }
	
	public void jump(int[] nums, int currentStep, int currentIndex){
		if(currentIndex + nums[currentIndex] >= nums.length){
			minimumSteps = Math.min(minimumSteps, currentStep+1);
			return;
		}
		if(minimumSteps!=0 && currentStep >= minimumSteps){
			return;
		}
		for(int i = 1; i<=nums[currentIndex] ; i++){
			jump(nums, currentStep+1, currentIndex+i);
		}
	}
	//逆向测试用例超时 数字极长而且index=0时就可以到达终点
	public int jump2(int[] nums){
		int minimumSteps = 0;
		int last = nums.length - 1;
		while(last != 0){
			int nextLast = last;
			for(int i =last-1 ; i>=0 ; i--){
				if(nums[i] + i >= last){
					nextLast = i;
				}
			}
			last = nextLast;
			minimumSteps++;
		}
		
		return minimumSteps;
	}
	
	//BFS算法
	public int jump3(int[] nums){
		int length = nums.length ; 
        if(length<2) return 0;
        int currentMax = 0, i = 0, nextMax = 0, level = 0;;
        while(currentMax-i+1 > 0){
            level++;
            for( ; i <= currentMax ; i++){
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax>=length-1) return level;
            }
            currentMax = nextMax;
        }
        //说明无法到达终点
        return nextMax>=length-1? level : -1;
	}
	public static void main(String[] args){
		JumpGameII_45 j = new JumpGameII_45();
		System.out.println(j.jump(new int[]{
				8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5
		}));
	}
	
}
