package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 * https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * 
 * Example 1:
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * Example 2:
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs_336 {
	
	public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = buildTrie(words);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i <words.length ; i++) {
        	String word = words[i];
        	findPalindromePairs(word, root, i, result);
        }
        return result;
    }
	
	public void findPalindromePairs(String word, TrieNode root, int index, List<List<Integer>> result) {
		for(int i = 0 ; i<word.length() ; i++) {
			if(root.index>=0 && root.index != index && isPalindrome(word, i, word.length()-1)) {
				result.add(Arrays.asList(index, root.index));
			}
			root = root.next[word.charAt(i)-'a'];
			if(root == null) return;
		}
		for(int palindromeSuffixIndex : root.palindromeSuffixIndexs) {
			if(palindromeSuffixIndex != index) {
				result.add(Arrays.asList(index, palindromeSuffixIndex));
			}
		}
	}
	
	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		TrieNode tmp = root;
		for(int i = 0 ; i<words.length ; i++) {
			String word = words[i];
			for(int j = word.length()-1 ; j>=0 ; j--) {
				int index = word.charAt(j) - 'a';
				if(tmp.next[index] == null) {
					tmp.next[index] = new TrieNode();
				}
				if(isPalindrome(word, 0, j)) {
					tmp.palindromeSuffixIndexs.add(i);
				}
				tmp = tmp.next[index];
			}
			tmp.palindromeSuffixIndexs.add(i);
			tmp.index = i;
			tmp = root;
		}
		return root;
	}
	
	
	public boolean isPalindrome(String word, int start, int end) {
		while(start < end) {
			if(word.charAt(start) != word.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
	

	public static class TrieNode{
		TrieNode[] next;
		List<Integer> palindromeSuffixIndexs;
		int index;
		
		public TrieNode(){
			next = new TrieNode[26];
			palindromeSuffixIndexs = new ArrayList<>();
			index = -1;
		}
	}
	
	public static void main(String[] args) {
		PalindromePairs_336 p = new PalindromePairs_336();
		p.palindromePairs(new String[]{
				"abcd","dcba","lls","s","sssll"
		});
	}
}
