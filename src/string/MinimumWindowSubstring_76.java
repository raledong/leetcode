package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring_76 {

	public String minWindow(String s, String t) {
		//hashmap另一种形式
		int[] characters = new int[128];
		for(int i = 0 ; i<t.length() ; i++){
			characters[t.charAt(i)]++;
		}
		//记录是否合格
		int start=0, end = 0 , counter = t.length() , length = Integer.MAX_VALUE, head = 0;
		while(end<s.length()){
			if(characters[s.charAt(end++)]-->0) counter--;
			while(counter==0){//valid
				if(end-start<length) length = end - (head=start);
				if(characters[s.charAt(start++)]++==0)counter++;//invalid
			}
		}
		return length==Integer.MAX_VALUE ? "" : s.substring(head, length);
    }
}
