package other;

/**
 * @author rale
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */
public class AdditiveNumber_306 {
	public boolean isAdditiveNumber(String num) {
		if(num==null || num.length() < 3) return false;
		for(int i = 1 ; i<=num.length()/2; i++){
            if(num.charAt(0)=='0' && i>1) break;
			String s1 = num.substring(0, i);
			long num1 = Long.parseLong(s1);
			for(int j = i+1 ; j<=num.length()-i ; j++){
				if(num.charAt(i)=='0' && j>i+1) break;
				String s2 = num.substring(i, j);
				long num2 = Long.parseLong(s2);
				if(isAdditiveNumber(num.substring(j), num1, num2)){
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean isAdditiveNumber(String num, long num1, long num2){
		if(num.length()==0) return true;
		long add = num1 + num2;
		String adds = add + "";
		return num.startsWith(adds) && isAdditiveNumber(num.substring(adds.length()), num2, add);
	}
}
