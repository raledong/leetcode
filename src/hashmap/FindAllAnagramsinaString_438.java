package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString_438 {
	public List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> result = new ArrayList<Integer>();
		if(p==null || s==null || p.isEmpty() || s.isEmpty()) return result;
        
		int startIndex = 0;
		int[] map = new int[26];
		for(char c : p.toCharArray()) {
			map[c-'a']++;
		}
		
		char[] sArray = s.toCharArray();
		int[] tmpMap = Arrays.copyOf(map, map.length);
		for(int i = 0 ; i<sArray.length ; i++) {
			int index = sArray[i] - 'a';
			if(tmpMap[index] > 0) {
				tmpMap[index]--;
				if(i - startIndex + 1 == p.length()) {
					result.add(startIndex);
					tmpMap[sArray[startIndex]-'a']++;
					startIndex++;
				}
			}else if(sArray[startIndex] == sArray[i]){
				startIndex++;
			}else {
				startIndex = i--;
				tmpMap = Arrays.copyOf(map, map.length);
			}
		}
		return result;
    }
	
	public static void main(String [] args) {
		FindAllAnagramsinaString_438 f = new FindAllAnagramsinaString_438();
		f.findAnagrams("abaacbabc", "abc");
	}
}
