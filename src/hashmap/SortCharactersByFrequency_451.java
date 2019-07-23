package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency_451 {
	
	/**
	 * 使用流处理进行排序
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
		if(s==null || s.isEmpty() || s.length() <= 1) return s;
        Map<Character, StringBuilder> map = new HashMap<>();
        for(char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }
        StringBuilder result = map
        		.values()
        		.stream()
        		.sorted((sb1, sb2) -> {
        			return sb2.length() - sb1.length();
        		})
        		.reduce((sb1, sb2) -> sb1.append(sb2))
        		.get();
        return result.toString();
    }
	
	public String frequencySort2(String s) {
        char[] charArr = new char[128];
        
        
        for(char c :  s.toCharArray()) 
            charArr[c]++;
        
        StringBuilder sb = new StringBuilder();

        
        while(sb.length() < s.length()) {
                    char maxChar = 0;
            for(char charCur = 0; charCur < charArr.length; charCur++) {
                
                if(charArr[charCur] > charArr[maxChar]) {
                    maxChar = charCur;
                }
            }
            while(charArr[maxChar] > 0){
            	sb.append(maxChar);
            	charArr[maxChar]--;
            }
           
        }
        
        return sb.toString();
    }
	public static void main(String[] args) {
		SortCharactersByFrequency_451 s = new SortCharactersByFrequency_451();
		s.frequencySort2("ertt");
	}
}
