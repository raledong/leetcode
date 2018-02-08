package math;

/**
 * @author rale
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberOfDigitOne_233 {
	
	public int countDigitOne(int n) {
        if(n <= 0) return 0;
		if(n < 10) return 1;
        int count = 1;
        while(n / count > 9){
        	count *= 10;
        }
        if(n / count == 1){
        	return n % count + 1 + countDigitOne(n%count) + countDigitOne(count-1);
        }else{
        	return countDigitOne(n % count) + count + (n/count) * countDigitOne(count-1);
        }
    }

}
