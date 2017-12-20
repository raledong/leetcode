package other;

/**
 * @author rale
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits_191 {

	public int hammingWeight(int n) {
		int mask = 1;
		int count = 0;
		while(n!=0){
			if((n & mask) == 1) count ++;
			n >>>= 1;
		}
		return count;
    }
}
