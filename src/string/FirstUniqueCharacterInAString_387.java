package string;

/**
 * @author rale
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharacterInAString_387 {
	public int firstUniqChar(String s) {
        if(s==null) return -1;
        int[] count = new int[26];
        char[] array = s.toCharArray();
        for(int i = 0 ; i<array.length ; i++) {
        	count[array[i] - 'a']++;
        }
        
        for(int i = 0 ; i<array.length ; i++) {
        	if(count[array[i] - 'a'] == 1){
        		return i;
        	} 
        }
        return -1;
    }
}
