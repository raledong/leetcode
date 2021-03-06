package math;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * 
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 * 
 * Example 2:
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 * @author rale
 *
 */
public class NthDigit_400 {

	public int findNthDigit(int n) {
		n--;
        
        int start = 1;
        int size = 1;
        while (n / 9 / size >= start) {
            n -= 9 * start * size;
            start *= 10;
            size++;
        }
        
        int number = start + n / size;
        for (int i = n % size; i < size - 1; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
