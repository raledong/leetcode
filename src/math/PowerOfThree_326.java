package math;

/**
 * @author rale
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree_326 {
	//1162261467 = 3的19次方
	public boolean isPowerOfThree(int n) {
		return ( n>0 &&  1162261467%n==0);
    }
}
