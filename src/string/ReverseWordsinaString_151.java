package string;

/**
 * @author rale
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * 
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 * click to show clarification.
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * 
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * 
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString_151 {

	//超时
	public String reverseWords1(String s) {
        s = s.trim();
        int length = s.length();
        int pointer1 = length, pointer2 = pointer1-1;
        while(pointer1>=0){
        	while(pointer2>=0 && s.charAt(pointer2)!=' '){
        		pointer2--;
        	}
        	s += s.substring(pointer2+1, pointer1);
        	pointer1 = pointer2+1;
        	if(pointer1!=0){
        		while(pointer2>=0 && s.charAt(pointer2)==' '){
            		pointer2--;
            	}
        		s += " ";
        		pointer1 = pointer2+1;
        	}
        }
        return s.length()==length ? s : s.substring(length);
    }
	
	//using api
	public String reverseWords2(String s) {
		String[] array = s.trim().split("\\s+");
		String result = "";
		for(int i = array.length-1 ; i>0 ; i--){
			result += array[i] + " ";
		}
		return result + array[0];
	}
	
	//using api without regex
	//核心思路还是双指针，不过查找的问题交给了底层来完成
	public String reverseWords3(String s){
		String trimmed = s.trim();
        int prev = trimmed.length();
        int index = prev;
        StringBuilder result = new StringBuilder();
        while ((index = trimmed.lastIndexOf(' ', index-1)) > 0) {
            if (index < prev-1) {
                result.append(trimmed.substring(index+1, prev));
                result.append(" ");
            }
            prev = index;
        }
        result.append(trimmed.substring(index+1, prev));
        return result.toString();
	}
}
