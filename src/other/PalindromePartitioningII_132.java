package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII_132 {
	
	//超时
	Map<Character, List<Integer>> cache = new HashMap<Character, List<Integer>>();
	public int minCut(String s) {
		if(s==null || s.length()==0) return 0;
        int[] minCut = new int[s.length()+1];
        minCut[0] = -1;
        for(int i = 0 ; i<s.length() ; i++){
        	char cur = s.charAt(i);
        	if(!cache.containsKey(cur)){
        		minCut[i+1] = minCut[i] + 1;
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		cache.put(cur, list);
        	}else{
        		int max = minCut[i] + 1;
        		List<Integer> values = cache.get(cur);
        		for(int index : values){
        			if(isPalindrome(s.substring(index, i+1))){
        				max = Math.min(max, minCut[index]+1);
        			}
        		}
        		minCut[i+1] = max;
        		values.add(i);
        	}
        }
        return minCut[s.length()];
    }
	
	public boolean isPalindrome(String subString){
		if(subString.length()<=1) return true;
		char[] sArray = subString.toCharArray();
		int left = 0,
				right = subString.length()-1;
		while(left<right){
			if(sArray[left] != sArray[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public int minCut2(String s){
		if(s==null || s.length()<=1) return 0;
		int length = s.length();
		boolean[][] isPalindrome = new boolean[length][length];
		int[] result = new int[length];
		char[] array = s.toCharArray();
		for(int end = 0 ; end<length ; end++){
			result[end] = end; 
			for(int start = end ; start>=0 ; start--){
				if(array[start] == array[end]){
					if(end-start<=2){
						isPalindrome[start][end] = true;
					}else{
						isPalindrome[start][end] = isPalindrome[start+1][end-1];
					}
				}
				
				if(isPalindrome[start][end]){
					if(start==0){
						result[end] = 0;
					}else{
						result[end] = Math.min(result[start-1]+1, result[end]);
					}
				}
			}
		}
		return result[length-1];
	}
	public static void main(String[] args){
		PalindromePartitioningII_132 p = new PalindromePartitioningII_132();
		p.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
}
