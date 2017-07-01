package math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence_60 {
	public String getPermutation(int n, int k) {
		//factorial
		int[] factorial = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
		
		//初始化
		List<Integer> numbers = new LinkedList<Integer>();
        for(int i = 0 ; i<n ; i++){
        	numbers.add(i+1);
        }
        
		StringBuilder result = new StringBuilder();
        k--;
        for(int i = 0 ; i<n ; i++){
        	int currentNumber = numbers.remove(k / factorial[n-i-1]);
        	result.append(currentNumber);
        	k  %=  factorial[n-i-1] ;
        }
        return result.toString();
    }
	
	public static void main(String[] args){
		PermutationSequence_60 p = new PermutationSequence_60();
		System.out.println(p.getPermutation(3, 6));
	}
}
