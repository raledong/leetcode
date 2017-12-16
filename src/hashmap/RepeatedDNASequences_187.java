package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rale
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences_187 {
	
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        for(int i = 0 ; i<s.length()-9 ; i++){
        	String cur  = s.substring(i, i+10);
        	if(!visited.add(cur)){
        		result.add(cur);
        	}
        }
        return new ArrayList<String>(result);
    }
	
	//将四个字母转化成00，01，10，11 如果每次比较十位的话就是20bit，而整形有32bit，所以可以满足要求
	//A, C, G, and T
	public List<String> findRepeatedDnaSequences2(String s){
		
		List<String> result = new ArrayList<String>();
		Set<Integer> firstTime = new HashSet<Integer>();
		Set<Integer> secondTime = new HashSet<Integer>();
		char[] map = new char[26];
		map['A'-'A'] = 0;//00
		map['C'-'A'] = 1;//01
		map['G'-'A'] = 2;//10
		map['T'-'A'] = 3;//11
		char[] sArray = s.toCharArray();
		for(int i = 0 ; i<sArray.length-9 ; i++){
			int v = 0;
			for(int j = i ; j<i+10 ; j++){
				v <<= 2;
				v |= map[sArray[j] - 'A'];
			}
			if(!firstTime.add(v) && secondTime.add(v)){
				result.add(s.substring(i, i+10));
			}
		}
		return result;
		
	}
}
