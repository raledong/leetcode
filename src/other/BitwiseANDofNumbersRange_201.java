package other;

/**
 * @author rale
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDofNumbersRange_201 {
	
	public int rangeBitwiseAnd(int m, int n) {
		if(m==n) return m;
		int count = 0;
        while(m<n){
        	count++;
        	m >>>= 1 ;
        	n >>>= 1;
        }
        return m<<=count;
    }
	
	public int rangeBitwiseAnd2(int m, int n) {
		if(m==n) return m;
		int count = 1;
        while(m<n){
        	count <<= 1;
        	m >>>= 1 ;
        	n >>>= 1;
        }
        return m * count;
    }
}
