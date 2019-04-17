package string;

/**
 * @author rale
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * 
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * 
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * 
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 * 
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * 
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * 
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class StringCompression_443 {
	public int compress(char[] chars) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 1;
        while(p2 < chars.length) {
        	if(p3 >= chars.length || chars[p3] != chars[p2]) {
        		int length = p3 - p2;
        		chars[p1++] = chars[p2];
        		if(length != 1) {
        			int count = 0;
        			while(length != 0) {
        				int num = length % 10;
        				for(int i = p1+count ; i>p1 ; i--) {
        					chars[i] = chars[i-1];
        				}
        				chars[p1] = (char)('0' + num);
        				length /= 10;
        				count++;
        			}
        			p1 += count;
        		}
        		p2 = p3;
        	}
        	p3++;

        }
        return p1;
    }
	
	
}
