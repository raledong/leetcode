package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rale
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern_290 {
	
	public boolean wordPattern(String pattern, String str) {
		char[] patterns = pattern.toCharArray();
		String[] strs = str.split(" ");
		if(patterns.length != strs.length) return false;
		String[] map = new String[26];
		Set<String> hasMapped = new HashSet<String>();
		
		for(int i = 0 ; i<patterns.length ; i++){
			char curPattern = patterns[i];
			String curStr = strs[i];
			if(map[curPattern-'a']==null){
				if(!hasMapped.add(curStr)){
					return false;
				}
				map[curPattern-'a'] = curStr;
			}else if(!map[curPattern-'a'].equals(curStr)){
				return false;
			}
		}
		return true;
    } 
	
	public static void main(String[] args){
		WordPattern_290 w = new WordPattern_290();
		w.wordPattern("jquery", "jquery");
	}
}
