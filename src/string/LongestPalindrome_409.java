package string;

/**
 * @author rale
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome_409 {

	public int longestPalindrome(String s) {
        int[] count = new int[52];
        int max = 0;
        for(char c : s.toCharArray()) {
        	if(c>='a' && c<='z'){
        		count[c-'a']++;
        		if(count[c-'a'] % 2 == 0) {
        			max +=2;
        		}
        	}
        	
        	if(c>='A' && c<='Z'){
        		count[c-'A' + 26]++;
        		if(count[c-'A'+26] % 2 == 0) {
        			max += 2;
        		}
        	}
        }
        
        if(max < s.length()) {
        	max++;
        }
        return max;
    }
	
	public static void main(String[] args) {
		LongestPalindrome_409 l = new LongestPalindrome_409();
		l.longestPalindrome("AAAAAA");
	}
}
