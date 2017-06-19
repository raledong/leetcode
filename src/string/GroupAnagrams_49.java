package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 * 	["ate", "eat","tea"],
 * 	["nat","tan"],
 * 	["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams_49 {
	//这个方法超时了
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new LinkedList<List<String>>();
        L1:for(int i = 0 ; i < strs.length ; i++){
        	String temp = strs[i];
        	int tempLength = temp.length();
        	L2:for(int j = 0 ; j<result.size() ; j++){
        		List<String> currentList = result.get(j);
        		String currentString = currentList.get(0);
        		int currentStringLength = currentString.length();
        		if(currentStringLength>tempLength){
        			List<String> newResult = new ArrayList<String>();
        			newResult.add(temp);
        			result.add(j, newResult);
        			continue L1;
        		}else if (currentStringLength<tempLength){
        			continue L2;
        		}else{
        			if(isPermutation(currentString, temp)){
            			result.get(j).add(temp);
            			continue L1;
            		}
        		}
        		
        	}
        	List<String> newResult = new ArrayList<String>();
        	newResult.add(temp);
        	result.add(newResult);
        }
        return result;
    }

	public boolean isPermutation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		char[] s1array = s1.toCharArray();
		Arrays.sort(s1array);
		char[] s2array = s2.toCharArray();
		Arrays.sort(s2array);
		for(int i = 0 ; i<s1array.length ; i++){
			if(s1array[i] != s2array[i]){
				return false;
			}
		}
		return true;
	}
	
	//这个方法没有超时
	public List<List<String>> groupAnagrams2(String[] strs){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String temp : strs){
			char[] current = temp.toCharArray();
			Arrays.sort(current);
			String sortedTemp = String.valueOf(current);
			if(!map.containsKey(sortedTemp)){
				List<String> tempResult = new ArrayList<String>();
				tempResult.add(temp);
				map.put(sortedTemp, tempResult);
			}else{
				map.get(sortedTemp).add(temp);
			}
		}
		return new ArrayList<List<String>>(map.values());
	} 
	
	public static void main(String[] args){
		GroupAnagrams_49 g = new GroupAnagrams_49();
		System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	

}
