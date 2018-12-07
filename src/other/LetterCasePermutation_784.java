package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 * 
 * Note:
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation_784 {
	public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        letterCasePermutation(S.toCharArray(), new StringBuilder(), result, 0);
        return result;
    }
	
	public void letterCasePermutation(char[] sArray, StringBuilder s, List<String> result, int index){
		if(index == sArray.length) {
			result.add(s.toString());
			return;
		}else if(sArray[index] >= '0' && sArray[index] <= '9') {
			s.append(sArray[index]);
			letterCasePermutation(sArray, s, result, index+1);
			s.delete(s.length()-1, s.length());
		} else if(sArray[index] >= 'a' && sArray[index] <= 'z'){
			s.append(sArray[index]);
			letterCasePermutation(sArray, s, result, index+1);
			s.delete(s.length()-1, s.length());
			s.append((char)(sArray[index] - 'a' + 'A'));
			letterCasePermutation(sArray, s, result, index+1);
			s.delete(s.length()-1, s.length());
		} else{
			s.append(sArray[index]);
			letterCasePermutation(sArray, s, result, index+1);
			s.delete(s.length()-1, s.length());
			s.append((char)(sArray[index] - 'A' + 'a'));
			letterCasePermutation(sArray, s, result, index+1);
			s.delete(s.length()-1, s.length());
		}
	}
	
	
	private void backtrack(char[] str, int i, List<String> list) {
        if (i == str.length) return;
        
        backtrack(str, i+1, list);
        
        //调用Character.isLetter判断是否为字母
        if (Character.isLetter(str[i])) {
        	//调用^32将字符进行大小写转换
            str[i] ^= 32;
            list.add(new String(str));
            backtrack(str, i+1, list);
        }
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        backtrack(S.toCharArray(), 0, result);
        return result;
    }
}
