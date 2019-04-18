package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rale
 *
 */
public class FrogJump_403 {
	public boolean canCross(int[] stones) {
		if(stones.length < 2) return true;
		if(stones.length == 2 && stones[1] == 1) return true;
		if(stones.length >= 2 && stones[1] != 1) return false;
        Map<Integer, Set<Integer>> stoneJump = new HashMap<>();
        for(int i = 1 ; i<stones.length ; i++) {
        	stoneJump.put(stones[i], new HashSet<>());
        }
        stoneJump.get(1).add(1);
        int finalStone = stones[stones.length-1];
        boolean hasNext = false;
        for(int i = 1 ; i<stones.length; i++) {
        	for(int step : stoneJump.get(stones[i])) {
        		int next = stones[i] + step - 1;
        		for(int addOn = -1 ; addOn <= 1 ; addOn++) {
        			if(step + addOn != 0) {
        				if(next == finalStone) {
        					return true;
        				}
        				if(stoneJump.containsKey(next)) {
        					stoneJump.get(next).add(step + addOn);
        					hasNext = true;
        				}
        			}
        			next++;
        		}
        		
        	}
        	if(!hasNext) break;
        	hasNext = false;
        }
        return false;
    }
	
	public boolean canCross2(int[] stones) {
		for(int i = 1 ; i<stones.length ; i++) {
			if(stones[i] - stones[i-1] > i) return false;
		}
		return canCross2(stones, 1, 1);
	}
	
	public boolean canCross2(int[] stones, int idx, int lastStep) {
		if(idx == stones.length-1) return true;
		if(idx < 0 || lastStep <= 0) return false;
		for(int jump = lastStep + 1 ; jump >= lastStep -1 ; jump--) {
			if(canCross2(stones, Arrays.binarySearch(stones, stones[idx] + jump), jump)){
				return true;
			}
		}
		return false;
	}
}
