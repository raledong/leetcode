package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author rale
 * Given a List of words, 
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * 
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow_500 {

	public String[] findWords(String[] words) {
        return Stream.of(words)
        		.filter(word -> word.toLowerCase().matches("([qwertyuiop]*)|([asdfghjkl]*)|([zxcvbnm]*)"))
        		.toArray(String[]::new);
    }
	
	public int row(char c) {
        switch (c) {
            case 'q':
            case 'w':
            case 'e':
            case 'r':
            case 't':
            case 'y':
            case 'u':
            case 'i':
            case 'o':
            case 'p':
            case 'Q':
            case 'W':
            case 'E':
            case 'R':
            case 'T':
            case 'Y':
            case 'U':
            case 'I':
            case 'O':
            case 'P':
                return 1;
            case 'a':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'A':
            case 'S':
            case 'D':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
                return 2;
            case 'z':
            case 'x':
            case 'c':
            case 'v':
            case 'b':
            case 'n':
            case 'm':
            case 'Z':
            case 'X':
            case 'C':
            case 'V':
            case 'B':
            case 'N':
            case 'M':
                return 3;
            default:
                return -1;
        }
    } 
    
    public String[] findWords2(String[] words) {
        String[] result;
        ArrayList<String> al = new ArrayList<String>();
        int startRow = 0;
        int count = 0;
        
        for (String s : words) {
            startRow = row(s.charAt(0));
                       
            for (int i=0 ; i<s.length() ; i++) {
                if (startRow != row(s.charAt(i))) {                    
                    break;
                }
                if (i==s.length()-1) {
                    al.add(s);
                }
            }
        }
        
        result = new String[al.size()];
        for (String s:al) {
            result[count++] = s;
        }
        
        return result;
    }
}
