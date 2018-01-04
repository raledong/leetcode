package other;

import java.util.Arrays;

/**
 * @author rale
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram_242 {
	
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int length = s.length();
        int[] letters = new int[26];
        for(int i = 0 ; i<length ; i++){
        	char s1 = s.charAt(i);
        	letters[s1-'a']++;
        	char t1 = t.charAt(i);
        	letters[t1-'a']--;
        }
        for(int num : letters){
        	if(num != 0 ) return false;
        }
        return true;
    }
	
	public boolean isAnagram2(String s, String t){
		if(s.length() != t.length()) return false;
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(t1);
		for(int i = 0 ; i<s1.length ; i++){
			if(s1[i] != t1[i]) return false;
		}
		return true;
	}
}
