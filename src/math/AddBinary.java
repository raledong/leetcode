package math;

/**
 * @author rale
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
	
	public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
		int pointerA = a.length()-1;
		int pointerB = b.length()-1;
		int carry = 0;
		while(pointerA>=0 || pointerB>=0){
			int sum = carry;
			if(pointerA>=0){
				sum += (a.charAt(pointerA)-'0');
				pointerA--;
			}
			if(pointerB>=0){
				sum += (b.charAt(pointerB)-'0');
				pointerB--;
			}
			result.append(sum%2);
			carry = sum/2;
		}
		if(carry!=0){
			result.append('1');
		}
		return result.reverse().toString();
	}
}
