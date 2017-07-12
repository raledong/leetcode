package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * 	[2],
 * 	[1],
 * 	[1,2,2],
 * 	[2,2],
 *  [1,2],
 *  []
 * ]
 */
public class SubsetsII_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i<length ; ){
        	LinkedList<List<Integer>> temp = new LinkedList<List<Integer>>();
        	for(List<Integer> tempResult : result){
        		List<Integer> copyTemp = new ArrayList<Integer>(tempResult);
        		copyTemp.add(nums[i]);
        		temp.add(copyTemp);
        	}
        	i++;
        	while(i<length && nums[i]==nums[i-1]){
        		int size = temp.size();
        		while(size-->0){
        			List<Integer> currentTemp = temp.removeFirst();
        			result.add(currentTemp);
        			List<Integer> moreCurrentTemp = new ArrayList<Integer>(currentTemp);
        			moreCurrentTemp.add(nums[i]);
        			temp.add(moreCurrentTemp);
        		}
        	}
        	result.addAll(temp);
        }
        return result;
    }
	
	
	//递归
	public List<List<Integer>>  subsetsWithDup2(int[] nums) {
        List<List<Integer>> fnl = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(fnl, new ArrayList<Integer>(), nums, 0);
        return fnl;
    }
    
    public void helper(List<List<Integer>> fnl, List<Integer> temp, int[] nums, int start){
        fnl.add(new ArrayList<Integer>(temp));
        for(int i =start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(fnl, temp, nums, i+1 );
            temp.remove(temp.size()-1);
        }
        
    }
	public static void main(String[] args){
		
	}
}
