package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class CombinationSumIII_216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum3(k,n,1,result, new ArrayList<Integer>());
        return result;
    }
	
	public void combinationSum3(int k, int n, int startNumber, List<List<Integer>> result, List<Integer> current){
		if(k==0 && n==0){ result.add(new ArrayList<Integer>(current)); return;}
		if(k==0 || n<0) return;
		for(int i = startNumber ; i<=9 ; i++){
			if(i>n){
				break;
			}
			current.add(i);
			combinationSum3(k-1, n-i, i+1, result, current);
			current.remove(current.size()-1);
		}
	}
	
	public static void main(String[] args){
		CombinationSumIII_216 c = new CombinationSumIII_216();
		c.combinationSum3(3, 7);
	}
}
