package other;

/**
 * @author rale
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * 
 * Example:
 * Given "bcabc"
 * Return "abc"
 * 
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters_316 {
	
	//找到当前能够找到的最远最小的字符，然后再从剩下的里面继续寻找
	public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
        	count[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for(int i = 0 ; i<s.length() ; i++){
        	if(s.charAt(pos) > s.charAt(i)) pos = i;
        	if(--count[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replace(s.charAt(pos) + "", ""));
    }
	
	
}
