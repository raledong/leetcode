package string;

/**
 * @author rale
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	//递归 超时
	public int numDecodings(String s) {
		if(s==null || s.isEmpty()) return 0;
        char[] message = s.toCharArray();
        return numDecodings(message, 0);
    }
	
	public int numDecodings(char[] message, int startIndex){
		if(startIndex>=message.length || message[startIndex]=='0') return 0;
		if(startIndex==message.length-1) return 1;
		if(message[startIndex] =='3' || (startIndex<message.length-1 && message[startIndex]=='2'&&message[startIndex+1]>'6')) return numDecodings(message, startIndex+1);
		return numDecodings(message, startIndex+1) + numDecodings(message, startIndex+2);
		
	}
	
	public int numDecodings2(String s){
		int length = s.length();
		if(length==0) return 0;
		int[] temp = new int[length+1];
		temp[length] = 1;
		temp[length-1] = s.charAt(length-1)=='0' ? 0 : 1;
		for(int i = length-2 ; i>=0 ; i--){
			if(s.charAt(i)=='0') continue;
			if(Integer.parseInt(s.substring(i, i+2))<26){ temp[i] = temp[i+1] + temp[i+2];}
			else{ temp[i] = temp[i+1];}
		}
		return temp[0];
	}
}
