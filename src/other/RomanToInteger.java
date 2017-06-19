package other;

/**
 * @author rale
 *
 *Given a roman numeral, convert it to an integer.
 *Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {
	public int romanToInt(String s) {
        if(s==null || s.equals("")){
        	return 0;
        }
        if(s.length()==1){
        	return singleRomanToInt(s.charAt(0));
        }
        s += 'O';
        int result = 0;
        char[] romanChars = s.toCharArray();
        char current = romanChars[0];
        char next = romanChars[1];
        int temp = singleRomanToInt(current);
        for(int i = 0 ; i<romanChars.length-1 ; i++){
        	current = romanChars[i];
        	next = romanChars[i+1];
        	int currentInt = singleRomanToInt(current);
        	int nextInt = singleRomanToInt(next);
        	if(currentInt==nextInt){
        		temp += nextInt;
        	}else if(currentInt<nextInt){
        		result -= temp;
        		temp = nextInt;
        	}else if(currentInt>nextInt){
        		result += temp;
        		temp = nextInt;
        	}
        }
        return result;
    }
	private int singleRomanToInt(char s){
		int result = 0;
		switch(s){
		case 'I' : 
			result = 1;
			break;
		case 'V' :
			result = 5;
			break;
		case 'X' :
			result = 10;
			break;
		case 'L' :
			result = 50;
			break;
		case 'C' :
			result = 100;
			break;
		case 'D' :
			result = 500;
			break;
		case 'M' :
			result = 1000;
			break;
		default :
			result = 0;
			break;
		}
		return result;
	}
	
	public static void main(String[] args){
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("IX"));
	}
}
