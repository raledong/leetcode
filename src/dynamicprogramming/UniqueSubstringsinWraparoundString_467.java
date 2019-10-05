package dynamicprogramming;

/**
 * @author rale
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", 
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. 
 * In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * 
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * 
 * Example 1:
 * Input: "a"
 * Output: 1
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * 
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * 
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class UniqueSubstringsinWraparoundString_467 {
	
	public int findSubstringInWraproundString(String p) {
        int[] preMaxSubstring = new int[26];
        int prevLength = 0;
        int count = 0;
        for(int i = 0 ; i<p.length() ; i++) {
        	char c = p.charAt(i);
        	if(i == 0) {
        		count++;
        		preMaxSubstring[c-'a']++;
        		prevLength++;
        	}else {
        		char prev = p.charAt(i-1);
        		prevLength = (prev-'a'+1) % 26 == (c-'a') ? prevLength+1 : 1;
        		if(prevLength > preMaxSubstring[c-'a']) {
        			count += prevLength - preMaxSubstring[c-'a'];
        			preMaxSubstring[c-'a'] = prevLength;
        		}
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		UniqueSubstringsinWraparoundString_467 u = new UniqueSubstringsinWraparoundString_467();
		u.findSubstringInWraproundString("zaba");
	}
	
}
