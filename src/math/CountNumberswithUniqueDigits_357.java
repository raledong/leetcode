package math;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Input: 2
 * Output: 91 
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
 * @author rale
 *
 */
public class CountNumberswithUniqueDigits_357 {
	/**
	 * f(0) = 1
	 * f(k) = 9 * 9 * ... (9-k+2)
	 * @param n
	 * @return
	 */
	public int countNumbersWithUniqueDigits(int n) {
        if(n==0) {
            return 1;
        } else if(n > 10){
            n = 10;
        }
        int cur = 9;
        for(int i = 0 ; i < n - 1 ; i++) {
        	cur *= (9 - i);
        }
        return cur + countNumbersWithUniqueDigits(n-1);
    }
}
