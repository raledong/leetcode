package array;

import java.util.TreeSet;

/**
 * @author rale
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
 * the absolute difference between nums[i] and nums[j] is at most t 
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII_220 {
	 
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
			if(nums == null || nums.length <= 1 || k == 0) return false;
			
			TreeSet<Long> potentialNums = new TreeSet<Long>();
			for(int i = 0 ; i<nums.length ; i++){
				long curNum = nums[i];
				
				long ceilVal = curNum - t;
	        	Long ceiling = potentialNums.ceiling(ceilVal);
	        	
	        	long floorVal = curNum + t;
	        	Long floor = potentialNums.floor(floorVal);
	        	
	        	if(ceiling != null && ceiling <= curNum)return true;
	        	if(floor != null && floor >= curNum) return true;
	        	potentialNums.add(curNum);
	        	if(i >= k) potentialNums.remove((long)nums[i-k]);
			}
	        return false;
	}
	
	public static void main(String[] args){
		ContainsDuplicateIII_220 c = new ContainsDuplicateIII_220();
		c.containsNearbyAlmostDuplicate(new int[]{1,3,1}, 1, 1);
	}
}
