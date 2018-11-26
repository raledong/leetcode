package math;
/**
 * 
 * @author rale
 * Given a positive integer n and you can do operations as follow:
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * Example 1:
 * Input:
 * 8
 * Output:
 * 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 
 * Example 2:
 * Input:
 * 7
 * Output:
 * 4
 * 
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */
public class IntegerReplacement_397 {
	
	public int integerReplacement(int n) {
		if(n == 1) {
			return 0;
		}else if(n % 2 == 0) {
			return 1 + integerReplacement(n / 2);
		} else {
			return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
		}
    }
	
	public int integerReplacement2(int n) {
        int count = 0;
        while(n != 1){
            if((n & 1) == 0){
                n >>>= 1;
            }
            else if(n == 3 || ((n>>>1) & 1) == 0){
                n--;
            }
            else{
                n++;
            }
            count++;
        }
        return count;
    }
}
