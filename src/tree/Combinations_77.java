package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations_77 {
	 //n=20 k=16 超时 
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> result = new LinkedList<List<Integer>>();
	        if(k==0){
	        	return result;
	        }
	        for(int i = 0 ; i+k<=n ; i++){
	        	result.add(Arrays.asList(i+1));
	        }
	        while(result.get(0).size() != k){
	        	List<Integer> currentList = result.remove(0);
	        	for(int i = currentList.get(currentList.size()-1) + 1 ; i<=n ; i++){
	        		List<Integer> temp = new ArrayList<Integer>(currentList);
	        		temp.add(i);
	        		result.add(temp);
	        	}
	        }
	        return result;
	 }
	 
	 public List<List<Integer>> combine2(int n, int k){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(k==0) return result;
		 combine3(result, new ArrayList<Integer>(), 1, n, k);
		 return result;
	 }
	 
	 public void combine2(List<List<Integer>> currentResult, List<Integer> list, int start, int n, int k){
		 if(k==0){
			 currentResult.add(new ArrayList<Integer>(list));
			 return;
		 }
		 for(int i = start ; i<=n ; i++){
			 list.add(i);
			 combine2(currentResult, list, i+1, n, k-1);
			 list.remove(list.size()-1);
		 }
	 }
	 
	 public void combine3(List<List<Integer>> currentResult, List<Integer> list, int start, int n, int k){
		 if(k==0){
			 currentResult.add(new ArrayList<Integer>(list));
			 return;
		 }
		 while(start+k-1<=n){
			 list.add(start++);
			 combine3(currentResult, list, start, n, k-1);
			 list.remove(list.size()-1);
		 }
	 }
	 public static void main(String[] args){
		 Combinations_77 c = new Combinations_77();
		 System.out.println(c.combine2(4, 2).size());
	 }
}
