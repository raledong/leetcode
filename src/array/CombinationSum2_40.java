package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 *
 *Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *Each number in C may only be used once in the combination.
 *Note:
 *All numbers (including target) will be positive integers.
 *The solution set must not contain duplicate combinations.
 *For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 *A solution set is: 
 [
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class CombinationSum2_40 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int length = candidates.length;
        for(int i = 0 ; i<length ; i++){
        	if(i>0 && candidates[i] == candidates[i-1]){continue;}
        	if(candidates[i] == target){
        		result.add(Arrays.asList(candidates[i]));
        	}else{
            	List<Integer> temp = new ArrayList<Integer>();
            	temp.add(candidates[i]);
            	combinationSum2(candidates, target-candidates[i], i+1, temp);
        	}
        }
        return result;
    }
	
	public void combinationSum2(int[] candidates, int target, int startAt, List<Integer> currentList){
		for(int i = startAt ; i<candidates.length ; i++){
			if(candidates[i] == target){
				currentList.add(candidates[i]);
				result.add(currentList);
				return;
			}
			if(candidates[i] > target){
				return;
			}
			if(candidates[i] < target){
				List<Integer> temp = new ArrayList<Integer>(currentList);
				temp.add(candidates[i]);
				combinationSum2(candidates, target-candidates[i], i+1, temp);
			}
			while(i<candidates.length-1 && candidates[i] == candidates[i+1]){i++;}
		}
	}
	
	public static void main(String[] args){
		CombinationSum2_40 c = new CombinationSum2_40();
		System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
	}
}
