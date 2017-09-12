package math;

/**
 * @author rale
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes_172 {

	public int trailingZeroes(int n) {
		int numOfFive = 0;
        while(n>0){
        	numOfFive+=n/5;
        	n/=5;
        }
        return numOfFive;
    }
	
	public static void main(String[] args){
		FactorialTrailingZeroes_172 f = new FactorialTrailingZeroes_172();
		System.out.println(f.trailingZeroes(125));
	}
}
