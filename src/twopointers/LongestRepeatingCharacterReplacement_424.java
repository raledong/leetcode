package twopointers;

import java.util.Arrays;

/**
 * @author rale
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * Note:
 * Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * Input:
 * s = "AABABBA", k = 1
 * Output:
 * 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement_424 {
	
	public int characterReplacement(String s, int k) {
		if(s == null || s.isEmpty()) return 0;
		int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for(int end = 0 ; end < s.length() ; end++) {
        	maxCount = Math.max(maxCount, count[s.charAt(end)-'A']);
        	if(end - start + 1 - maxCount > k) {
        		count[s.charAt(start++)-'A'] --;
        	}
        	maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
        
    }

}