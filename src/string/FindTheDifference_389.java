package string;

public class FindTheDifference_389 {
	
	public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for(int i = 0 ; i<t.length() ; i++) {
        	if(i != t.length()-1) {
        		count[s.charAt(i)-'a']++;
        	}
        	count[t.charAt(i)-'a']--;
        }
        for(int i = 0 ; i<count.length ; i++) {
        	if(count[i] != 0) {
        		return (char)('a' + i);
        	}
        }
        return 'a';
    }
	
	public char findTheDifference2(String s, String t){
		int value = 0;
		for(int i = 0 ; i<s.length() ; i++) {
			value -= s.charAt(i);
			value += t.charAt(i);
		}
		char result = (char)(value + t.charAt(t.length()-1)); 
		return result;
	}
}
