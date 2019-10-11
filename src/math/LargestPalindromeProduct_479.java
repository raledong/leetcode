package math;

/**
 * @author rale
 * Find the largest palindrome made from the product of two n-digit numbers.
 * 
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * 
 * Example:
 * Input: 2
 * Output: 987
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * Note:
 * The range of n is [1,8].
 */
public class LargestPalindromeProduct_479 {
	
	public int largestPalindrome(int n) {
		if(n == 1) return 9;
        int max = (int)Math.pow(10, n) - 1;
        for(int palindromePart = max - 1 ; palindromePart > max / 10 ; palindromePart--) {
        	long palindrome = Long.valueOf(palindromePart + new StringBuilder().append(palindromePart).reverse().toString());
        	for(long divided = max ; divided * divided >= palindrome ; divided--) {
        		if(palindrome % divided == 0) {
        			return (int) (palindrome % 1337);
        		}
        	}
        }
        return 0;
    }
}
