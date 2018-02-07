package math;

/**
 * @author rale
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo_231 {
	
	public boolean isPowerOfTwo(int n) {
		if(n==1) return true;
		while(n!=0){
    	   if ((n & 1) == 1) break;
    	   n >>>= 1;
		}
		return n==0;
    }
}
