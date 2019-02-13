package math;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author rale
 *
 */
public class DecodeString_394 {
	
	public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> letters = new Stack<>();
        int lft = 0, rgt = -1;
        int number = 0;
        StringBuilder result = null;
        while(++rgt < s.length()) {
        	char c = s.charAt(rgt);
        	if(c == '[') {
        		if(result != null) {
        			count.push(number);
        			letters.push(result);
        		}
        		result = new StringBuilder();
        		number = Integer.valueOf(s.substring(lft, rgt));
        		lft = rgt+1;
        	}else if(c == ']') {
        		result.append(s.substring(lft, rgt));        			
        		StringBuilder tmp = new StringBuilder(result);
        		for(int i = 0 ; i<number-1 ; i++) {
        			result.append(tmp);
        		}
        		if(!letters.isEmpty()) {
        			StringBuilder pop = letters.pop();
        			pop.append(result);
        			result = pop;
        			number = count.pop();
        		}
        		lft = rgt+1;
        	}else if(Character.isAlphabetic(c)) {
        		if(result==null) {
                    result = new StringBuilder();
                }
        		result.append(c);
        		lft = rgt+1;
        	}
        }
        if(result == null) {
        	result = new StringBuilder();
        }
        result.append(s.substring(lft, rgt));
        return result.toString();
    }
	
	/**
	 * 递归
	 * @param s
	 * @return
	 */
	public String decodeString2(String s) {
        if (s.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				// parse number
				int digitStart = i++;
				while (s.charAt(i) >= '0' && s.charAt(i) <= '9')
					i++;
				int num = Integer.parseInt(s.substring(digitStart, i));

				// parse next bracket pair
				int strStart = i+1; // number must be followed by '['
                int count = 1; 
                i++;
				while (count != 0) {
					if (s.charAt(i) == '[')
						count++;
					else if (s.charAt(i) == ']')
						count--;
					i++;
				}
				i--; // point to paired ']'

				// substring between '[' and ']'
				String subStr = s.substring(strStart, i);

				// decode substring after number
				String decodeStr = decodeString(subStr);

				// append decoded substring
				for (int j = 0; j < num; j++) {
					sb.append(decodeStr);
				}

			} else {
				// add starting letters
				sb.append(c);
			}

		}

		return sb.toString();
    }
	public static void main(String[] args) {
		DecodeString_394 d = new DecodeString_394();
		String result = d.decodeString("3[a2[c]]");
		System.out.println(result);
	}
	
}
