package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class SummaryRanges_228 {
	
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums==null || nums.length == 0) return result;
		
		int start = nums[0];
        for(int i = 1 ; i<nums.length ; i++){
        	if(nums[i] != nums[i-1] + 1){
        		result.add(formRange(start, nums[i-1]));
        		start = nums[i];
        	}
        	if(i == nums.length-1){
        		result.add(formRange(start, nums[i]));
        	}
        }
        return result;
    }
	
	public String formRange(int start, int end){
		return start==end? start+"" : start + "->" + end;
	}
}
