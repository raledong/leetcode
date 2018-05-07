package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rale
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString_345 {
	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e','i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		
		char[] letters = s.toCharArray();
		int leftPointer = 0 , rightPointer = letters.length - 1;
		while(leftPointer < rightPointer){
			char leftValue = letters[leftPointer];
			char rightValue = letters[rightPointer];
			
			boolean leftVowels = vowels.contains(leftValue);
			boolean rightVowels = vowels.contains(rightValue);
			if(leftVowels && rightVowels){
				letters[leftPointer++] = rightValue;
				letters[rightPointer--] = leftValue;
			}else if(leftVowels){
				rightPointer--;
			}else{
				leftPointer++;
			}
		}
		return new String(letters);
    }
	
	//用ASCII码表的形式存储
	public String reverseVowels2(String s) {
        boolean[] arr = new boolean[128];
        arr['a'] = true;
        arr['e'] = true;
        arr['i'] = true;
        arr['o'] = true;
        arr['u'] = true;
        arr['A'] = true;
        arr['E'] = true;
        arr['I'] = true;
        arr['O'] = true;
        arr['U'] = true;
        
        char[] str = s.toCharArray();
        int l = 0, r = str.length - 1;
        while (l < r) {
            while (l < r && !arr[str[l]]) {
                l++;
            }
            while (l < r && !arr[str[r]]) {
                r--;
            }
            if (l < r) {
                char t = str[l];
                str[l] = str[r];
                str[r] = t;
            }
            l++;
            r--;
        }
        return String.valueOf(str);
    }
	public static void main(String[] args){
		ReverseVowelsofaString_345 r = new ReverseVowelsofaString_345();
		r.reverseVowels("hello");
	}
}
