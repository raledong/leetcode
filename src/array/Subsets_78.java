package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * 	[3],
 * 	[1],
 * 	[2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 *  ]
 */
public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        subsets(result, nums, 0, new ArrayList<Integer>());
        return result;
    }
	
	public void subsets(List<List<Integer>> result, int[] nums, int startIndex, List<Integer> currentList){
		if(startIndex == nums.length){
			return;
		}
		while(startIndex<nums.length){
			currentList.add(nums[startIndex++]);
			result.add(new ArrayList<Integer>(currentList));
			subsets(result, nums, startIndex, currentList);
			currentList.remove(currentList.size()-1);
		}
	}
	
	//循环
	public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
	public static void main(String[] args){
		Subsets_78 s = new Subsets_78();
		s.subsets(new int[]{1,2,3});
	}
}
