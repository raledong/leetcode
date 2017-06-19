package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations_46 {

	public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums.length == 0){
        	return result;
        }
        List<Integer> first = new LinkedList<Integer>();
        first.add(0, nums[0]);
        result.add(first);
        List<Integer> temp;
        for(int i = 1 ; i<nums.length ; i++){
        	int number = nums[i];
        	do{
        		temp = result.removeFirst();
        		for(int j = 0 ; j <=temp.size() ; j++){
        			temp.add(j, number);
        			result.add(new LinkedList<Integer>(temp));
        			temp.remove(j);
        		}
        	}while(result.getFirst().size() == i);
        }
        return result;
    }
	
	public List<List<Integer>> permute2(int[] num) {
		   List<List<Integer>> ans = new ArrayList<List<Integer>>();
		    if (num.length ==0) return ans;
		    List<Integer> l0 = new ArrayList<Integer>();
		    l0.add(num[0]);
		    ans.add(l0);
		    for (int i = 1; i< num.length; ++i){
		        List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
		        for (int j = 0; j<=i; ++j){            
		           for (List<Integer> l : ans){
		        	   List<Integer> new_l = new ArrayList<Integer>(l);
		        	   new_l.add(j,num[i]);
		        	   new_ans.add(new_l);
		           }
		        }
		        ans = new_ans;
		    }
		    return ans;
	}
}
