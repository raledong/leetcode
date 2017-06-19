package string;

/**
 * @author rale
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */

public class LengthofLastWord {

	public int lengthOfLastWord(String s) {
        String[] slist = s.split(" ");
        return slist.length==0 ? 0 : slist[slist.length-1].length();
    }
	
	public int lengthOfLastWork(String s){
		s = s.trim();
	    int lastIndex = s.lastIndexOf(' ') + 1;
	    return s.length() - lastIndex;  
	}
}
