package other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rale
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class WordBreak_139 {
	
	//simple dp
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i = 0 ; i<s.length() ; i++){
			for(int j = i+1 ; j<=s.length() ; j++){
				if(dp[i] && wordDict.contains(s.substring(i,j))){
					dp[j]=true;
				}
			}
		}
		return dp[s.length()];
    }
	
	//upgraded dp
	public boolean wordBreak2(String s, List<String> wordDict){
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		Set<String> set = new HashSet<String>();
		int maxLength = 0;
		for(String word : wordDict){
			if(maxLength<word.length()) maxLength=word.length();
			set.add(word);
		}
		
		for(int i = 0 ; i<s.length() ; i++){
			for(int j = i ; j<=i+maxLength && j<=s.length() ; j++){
				if(dp[i] && set.contains(s.substring(i,j))) dp[j] = true;
			}
		}
		return dp[s.length()];
				
	}
}
