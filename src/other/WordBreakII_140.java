package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * You may assume the dictionary does not contain duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). 
 * Please reload the code definition to get the latest changes.
 */
public class WordBreakII_140 {
	private Map<String, List<String>> cache = new HashMap<String, List<String>>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		if(cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<String>();
        if(s.length()==0){
        	result.add("");
            return result;
        }
        
        for(String word : wordDict){
        	if(s.startsWith(word)){
        		List<String> subWords = wordBreak(s.substring(word.length()), wordDict);
        		for(String subWord : subWords){
        			result.add(word + (subWord.isEmpty() ? "" :" ") + subWord);
        		}
        		
        		
        	}
        }
        cache.put(s, result);
        return result;
    }
	
	public static void main(String[] args){
		WordBreakII_140 w = new WordBreakII_140();
		w.wordBreak("aaaaaaa",Arrays.asList("aaaa","aa","a"));
	}
}
