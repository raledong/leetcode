package string;

import java.util.HashMap;

/**
 * 需要重新尝试这题！leetcode3
 * @author rale
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	//太慢了
	public int lengthOfLongestSubstring(String s) {
		int length = 0;
		for(int i = 0 ; i<s.length() ; i++){
			if(length+i>s.length()){
		        break;
		    }
			String temp = ""+s.charAt(i);
			for(int j = i+1 ; j<s.length() ; j++){
				int index = temp.indexOf(s.charAt(j)+"");
				if(index >= 0){
					break;
				}
				temp+=s.charAt(j);
			}
			length = (temp.length()>length?temp.length():length);
			
		}
		return length;
    }
	
	public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
	
	//With 8 bit character set a character ascii value can assume 0 to 255 ( 2^8 -1) . So there are 256 unique values a character can have.
	//类似于map 利用唯一的char当做数组的下标，数组中填写该char所在的下标，若出现重复的，则更新下标并且重新计算
	public int lengthOfLongestSubstring3(String s) {
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }
        
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        int bestStart = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(lastIndices[cur]  < start){
                lastIndices[cur] = i;
                curLen++;
            }
            else{
                int lastIndex = lastIndices[cur];
                start = lastIndex+1;
                curLen = i-start+1;
                lastIndices[cur] = i;
            }
            
            if(curLen > maxLen){
                maxLen = curLen;
                bestStart = start;
            }
        }
        
        return maxLen;

    }
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
	}
}
