package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab"
 * Return
 * 
 * [
 * 	["aa","b"],
 * 	["a","a","b"]
 * ]
 */
public class PalindromePartitioning_131 {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		partition(s, 0, 0, result, new ArrayList<String>());
		return result;
    }
	
	public void partition(String s, int startIndex, int endIndex, List<List<String>> result, List<String> current){
		if(startIndex>=s.length()){ 
			result.add(new ArrayList<String>(current));
			return;
		}
		if(endIndex>=s.length()) return;
		for(int i = endIndex ; i<s.length() ; i++){
			if(isPalindrome(s, startIndex, i)){
				current.add(s.substring(startIndex, i+1));
				partition(s, i+1, i+1, result, current);
				current.remove(current.size()-1);
			}
		}
		
		
	}
	public boolean isPalindrome(String s, int startIndex, int endIndex){
		while(startIndex<endIndex){
			if(s.charAt(startIndex++)!=s.charAt(endIndex--)){
				return false;
			}
		}
		return true;
	}
	
	
    //方法2：通过先判断数组中能够组成回数，利用布尔数组存储相应的回数，减少遍历中的重复判断
    private void dfs(String s, boolean[][] booleanMatrix, int index, List<List<String>> result, List<String> cur, int n) {
        if (index == n) {
            result.add(new ArrayList<String> (cur));
            return;
        } 
        
        for (int j = index; j < n; j++) {
            if (booleanMatrix[index][j]) {
                cur.add(s.substring(index, j + 1));
                dfs(s, booleanMatrix, j + 1, result, cur, n);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition2(String s) {
        int n = s.length();
        boolean [][] booleanMatrix = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    booleanMatrix[i][j] = true;
                }
            }
        }
        
        dfs(s, booleanMatrix, 0, result, cur, n);
        return result;
    }
}
