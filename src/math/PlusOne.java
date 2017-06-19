package math;

/**
 * @author rale
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
        int carry = 1;
        int temp = 0;
        for(int i=digits.length-1 ; i>=0 ; i--){
        	temp = digits[i] + carry;
        	digits[i] = temp%10;
        	carry = temp/10;
        }
        if(carry>0){
        	int[] result = new int[digits.length+1];
        	result[0] = 1;
//          最高位进位的情况只有一种，即其它位均进位且为0，无需再循环一次
//        	for(int j = 1 ; j<result.length ; j++){
//        		result[j] = digits[j-1];
//        	}
        	return result;
        }
        return digits;
    }
	
	public static void main(String[] args){
		PlusOne p = new PlusOne();
		p.plusOne(new int[]{9});
	}
}
