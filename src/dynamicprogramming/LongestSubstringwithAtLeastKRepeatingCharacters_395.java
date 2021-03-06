package dynamicprogramming;

/**
 * 
 * @author rale
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * 
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * Output:
 * 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {
	
	
	public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length()-1);
    }
	
	public int longestSubstring(String s, int k, int left, int right) {
		if(left > right) {
			return 0;
		}

		int[] count = new int[26];
		for(int i = left ; i<=right ; i++) {
			count[s.charAt(i) - 'a']++;
		}
		int result = right - left + 1;
		for(int i = left ; i<=right ; i++) {
			if(count[s.charAt(i)-'a'] < k && count[s.charAt(i)-'a'] > 0) {
				int leftLongest = longestSubstring(s, k, left, i-1);
				int rightLongest = longestSubstring(s, k, i+1, right);
				result = Math.max(leftLongest, rightLongest);
				
				break;
			}
		}
		return result;
	}
}
