package math;

/**
 * @author rale
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 */
public class AddStrings_415 {

	public String addStrings(String num1, String num2) {
		if(num1 == null || num1.isEmpty()) return num2;
		if(num2 == null || num2.isEmpty()) return num1;
        int pointer1 = num1.length()-1, pointer2 = num2.length()-1, add = 0;
        StringBuilder result = new StringBuilder();
        while(pointer1>=0 && pointer2>=0) {
        	int n1 = num1.charAt(pointer1) - '0';
        	int n2 = num2.charAt(pointer2) - '0';
        	int tmp = (n1 + n2 + add) % 10;
        	add = (n1 + n2 + add) / 10;
        	result.append(tmp);
        	pointer1--;
        	pointer2--;
        }
        
        while(pointer1 >= 0) {
        	int n1 = num1.charAt(pointer1--) - '0';
        	int tmp  = (n1 + add) % 10;
        	add = (n1 + add) / 10;
        	result.append(tmp);
        }
        while(pointer2 >= 0) {
        	int n1 = num2.charAt(pointer2--) - '0';
        	int tmp = (n1 + add) % 10;
        	add = (n1 + add) / 10;
        	result.append(tmp);
        }
        if(add == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
	
	public static void main(String[] args) {
		AddStrings_415 a = new AddStrings_415();
		a.addStrings("6", "501");
	}
}
