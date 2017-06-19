package array;

/**
 * @author rale
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame_55 {
	//超时
	public boolean canJump(int[] nums) {
		int lastIndex= nums.length - 1;
        if(lastIndex < 0){
        	return false;
        } 
        return canJump(nums, 0, lastIndex);
    }
	
	public boolean canJump(int[] nums, int currentIndex, int lastIndex){
		int remainSteps = nums[currentIndex];
		if(currentIndex + remainSteps >= lastIndex){
			return true;
		}
		
		while(remainSteps-- > 0){
			boolean canJump = canJump(nums, ++currentIndex, lastIndex);
			if(canJump){
				return true;
			}
		}
		return false;
	}
	
	//利用逆向思维解答
	boolean canJump2(int A[]) {
	    int last=A.length-1,i;
	    for(i=last-1;i>=0;i--){
	        if(i+A[i]>=last)last=i;
	    }
	    return last==0;
	}
	
	public static void main(String[] args){
		JumpGame_55 j = new JumpGame_55();
		System.out.println(j.canJump(new int[]{3,2,1,0,4}));
	}
}
