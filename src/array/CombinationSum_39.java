package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class CombinationSum_39 {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		
		for(int i = 0 ; i<candidates.length ; i++){
			if(candidates[i] == target){
				result.add(Arrays.asList(candidates[i]));
			}else{ 
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(candidates[i]);
				combinationSum(candidates, i, target-candidates[i], temp);

			}
		}
        return result;
    }
	
	public void combinationSum(int[] candidates, int start, int target, List<Integer> currentResult){
		for(int i = start ; i < candidates.length ; i++){
//			System.out.println(currentResult);
			if(candidates[i] == target){
				currentResult.add(candidates[i]);
				result.add(currentResult);
				return;
			}
			if(candidates[i] > target){
				return;
			}
			if(candidates[i] < target){
				List<Integer> temp = new ArrayList<Integer>();
				temp.addAll(currentResult);
				temp.add(candidates[i]);
				combinationSum(candidates, i, target-candidates[i], temp);
			}
		}
	}
	
	
	//上面那种方法更好
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args){
		CombinationSum_39 c = new CombinationSum_39();
		System.out.println(c.combinationSum(new int[]{2,3,6,7}, 7));
	}
}
