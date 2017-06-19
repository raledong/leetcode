package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringwithConcatenationofAllWords_30 {

	//无法解决某些特殊情况，例如，输入的words中包含重复值(words=new String[]{"good", "bad", "good"})
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(words.length == 0){
			return result;
		}
		int wordLength = words[0].length();
		int allWordsLength = words.length;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        
        for(int j = 0 ; j<words.length ; j++){
        	wordMap.put(words[j], -1);
        }
        
        int start = 0;
        for(int i = 0 ; i<s.length()-wordLength ;){
        	String current = s.substring(i, i+wordLength);
        	if(wordMap.containsKey(current)){
        		int key = wordMap.get(current);
        		//出现重复情况
        		if(key>=start){
        			start = key + wordLength;
        		//长度等于所有长度
        		}else if(i-start == wordLength*(allWordsLength-1)){
        			result.add(start);
        			start+=wordLength;
        		}	
        		wordMap.replace(current, i);
        		i+=wordLength;
        		continue;
        	}
        	i++;
        	start = i;
        }
        return result;
    }
	
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(words.length == 0){
			return result;
		}
		int wordLength = words[0].length();
		int allWordsLength = words.length;
		
		
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for(int j = 0 ; j<words.length ; j++){
        	wordMap.put(words[j], wordMap.containsKey(words[j]) ? wordMap.get(words[j])+1 : 1);
        }
        
        for(int start = 0 ; start<=s.length()-wordLength*allWordsLength ; start++){
            Map<String, Integer> copy = new HashMap<String, Integer>(wordMap);
            for(int i=start ; i<start+wordLength*allWordsLength ; i+=wordLength){
            	String current = s.substring(i, i+wordLength);
            	if(copy.containsKey(current)){
            		int key = copy.get(current);
            		if(key==1){
            			copy.remove(current);
            		}else{
            			copy.put(current, key-1);
            		}
            		if(copy.isEmpty()){
                		result.add(start);
                		//及时跳出循环，否则可能造成超时问题
                		break;
                	}
            	}else{
            		break;
            	}	
            }
        }
        return result;
	}
	
	//效率值最高
	public List<Integer> findSubstring3(String s, String[] words) {
		//N为字符串长度
		int N = s.length();
		//结果集,长度必定不超过字符串长度
		List<Integer> indexes = new ArrayList<Integer>(s.length());
		if (words.length == 0) {
			return indexes;
		}
		//M为单个单词的长度
		int M = words[0].length();
		//如果所有单词连接之后的长度超过字符串长度，则返回空结果集
		if (N < M * words.length) {
			return indexes;
		}
		//last 字符串中最后一个可以作为单词起始点的下标
		int last = N - M + 1;
		
		//map each string in words array to some index and compute target counters
		Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
		int [][] table = new int[2][words.length];
		int failures = 0, index = 0;
		for (int i = 0; i < words.length; ++i) {
			Integer mapped = mapping.get(words[i]);
			if (mapped == null) {
				++failures;
				mapping.put(words[i], index);
				mapped = index++;
			}
			++table[0][mapped];
		}
		
		//find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
		int [] smapping = new int[last];
		for (int i = 0; i < last; ++i) {
			String section = s.substring(i, i + M);
			Integer mapped = mapping.get(section);
			if (mapped == null) {
				smapping[i] = -1;
			} else {
				smapping[i] = mapped;
			}
		}
		
		//fix the number of linear scans
		for (int i = 0; i < M; ++i) {
			//reset scan variables
			int currentFailures = failures; //number of current mismatches
			int left = i, right = i;
			Arrays.fill(table[1], 0);
			//here, simple solve the minimum-window-substring problem
			while (right < last) {
				while (currentFailures > 0 && right < last) {
					int target = smapping[right];
					if (target != -1 && ++table[1][target] == table[0][target]) {
						--currentFailures;
					}
					right += M;
				}
				while (currentFailures == 0 && left < right) {
					int target = smapping[left];
					if (target != -1 && --table[1][target] == table[0][target] - 1) {
						int length = right - left;
						//instead of checking every window, we know exactly the length we want
						if ((length / M) ==  words.length) {
							indexes.add(left);
						}
						++currentFailures;
					}
					left += M;
				}
			}
			
		}
		return indexes;
	}
	public static void main(String[] args){
		SubstringwithConcatenationofAllWords_30 s = new SubstringwithConcatenationofAllWords_30();
		s.findSubstring3(new String("wordgoodgoodgoodbestword"), new String[]{"word","good","best","good"});
	}
}
