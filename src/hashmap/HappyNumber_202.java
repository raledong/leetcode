package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rale
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 */
public class HappyNumber_202 {
	
	public boolean isHappy(int n) {
		Set<Integer> hasLoop = new HashSet<Integer>();
		while(hasLoop.add(n)){
			n = divideAndAdd(n);
		}
		return hasLoop.contains(1);
    }
	
	public int divideAndAdd(int n){
		int result = 0;
		while(n!=0){
			result += Math.pow((n%10), 2);
			n /= 10;
		}
		return result;
	}
	
	int digitSquareSum(int n) {
	    int sum = 0, tmp;
	    while (n!=0) {
	        tmp = n % 10;
	        sum += tmp * tmp;
	        n /= 10;
	    }
	    return sum;
	}

	boolean isHappy2(int n) {
	    int slow, fast;
	    slow = fast = n;
	    do {
	        slow = digitSquareSum(slow);
	        fast = digitSquareSum(fast);
	        fast = digitSquareSum(fast);
	    } while(slow != fast);
	    if (slow == 1) return true;
	    else return false;
	}
}
