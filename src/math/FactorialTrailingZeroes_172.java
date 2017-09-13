package math;

/**
 * @author rale
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 这题的思路其实等价于找到前n个数中一共含有多少个5，鉴于前n个数中的2一定比5多，所以只需要找5即可
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
