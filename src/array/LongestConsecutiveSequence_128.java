package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence_128 {

	public int longestConsecutive(int[] nums) {
		if(nums.length==0) return 0;
		Arrays.sort(nums);
		int max = Integer.MIN_VALUE;
		
		int tmpCount = 1;
		for(int i = 1 ; i<nums.length ; i++){
			if(nums[i] > nums[i-1]+1){
				max = Math.max(max, tmpCount);
				tmpCount = 1;
			}else if(nums[i] == nums[i-1] + 1){
				tmpCount++;
			}
		}
		max = Math.max(max, tmpCount);
		return max;
    }
	
	public int longestConsecutive2(int[] nums){
		if(nums.length<=1) return nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for(int i = 0 ; i<nums.length ; i++){
			int cur = nums[i];
			if(map.containsKey(cur)) continue;
			int left = map.getOrDefault(cur-1, 0);
			int right = map.getOrDefault(cur+1, 0);
			int sequence = left + right + 1;
			max = Math.max(max, sequence);
			map.put(cur, sequence);
			map.put(cur-left, sequence);
			map.put(cur+right, sequence);
		}
		return max;
	}
	
	public static void main(String[] args){
		LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
		l.longestConsecutive2(new int[]{
				1,2,0,1
		});
	}
}
