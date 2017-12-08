package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rale
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII_219 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0 ; i<nums.length ; i++){
        	int curNum = nums[i];
        	if(indexMap.containsKey(curNum)){
        		int prevIndex = indexMap.get(curNum);
        		if(i - prevIndex <= k){
        			return true;
        		}else{
        			indexMap.put(curNum, i);
        		}
        	}else{
        		indexMap.put(curNum, i);
        	}
        }
        return false;
    }
	
	public boolean containsNearbyDuplicate2(int[] nums, int k){
		Set<Integer> potentialSet = new HashSet<Integer>();
		for(int index = 0 ; index < nums.length ; index++){
			int curNum = nums[index];
			if(potentialSet.contains(curNum)){
				return true;
			}
			potentialSet.add(curNum);
			
			if(potentialSet.size() > k) potentialSet.remove(nums[index-k]);
		}
		return false;
	}
}
