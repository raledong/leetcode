package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber_17 {
	
	//数组
	String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		for(int i = 0 ; i<digits.length() ; i++){
			result = letterCombinations(digits.charAt(i), result);
		}
        return result;
    }
	
	public List<String> letterCombinations(char digit, List<String> currentList){
		int number = digit - '0';
		String letter = letters[number];
		if(letter.length()==0){
			return currentList;
		}
		
		if(currentList.size() == 0){
			for(int i = 0 ; i<letter.length() ; i++){
				currentList.add(letter.charAt(i)+"");
			}
			return currentList;
		}
		List<String> result = new ArrayList<String>();
		for(int i = 0 ; i<letter.length() ; i++){
			
			for(int j = 0 ; j<currentList.size() ; j++){
				StringBuilder temp = new StringBuilder(letter.charAt(i)+"");
				temp.insert(0, currentList.get(j));
				result.add(temp.toString());
			}
		}
		return result;
		
	}
	
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> l = new LinkedList<String>();
		if(digits.length()==0){
			return l;
		}
		l.add("");
		
		int empty = 0;
		for(int i = 0 ; i < digits.length() ; i++){
			int number = digits.charAt(i) - '0';

			String letter = letters[number];
			if(letter.length() == 0){
				empty++;
				continue;
			}
			while(l.peek().length() + empty == i){
				String peek = l.removeFirst();
				for(int j = 0 ; j<letter.length() ; j++){
					l.add(peek+letter.charAt(j));
				}
			}	
		}
		return l;
	}
	
	public static void main(String[] args){
		LetterCombinationsofaPhoneNumber_17 l = new LetterCombinationsofaPhoneNumber_17();
		System.out.println(l.letterCombinations2("161"));
	}
}
