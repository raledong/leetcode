package string;

/**
 * @author rale
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberOfSegmentsinaString_434 {
	
	public int countSegments(String s) {
        int count = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()) {
        	char c = s.charAt(right);
        	if(c == ' ') {
        		if(left != right){
            		count++;
            	}
        		left = right+1;
        	}
        	right++;
        }
        if(left!=right) count++;
        return count;
    }
}
