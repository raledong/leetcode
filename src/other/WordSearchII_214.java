package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, 
you could stop backtracking immediately. 
What kind of data structure could answer such query efficiently? 
Does a hash table work? Why or why not? How about a Trie? 
If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class WordSearchII_214 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		if(words.length==0 || board.length==0) return result; 
        TrieNode root = buildTrieNode(words);
        for(int i = 0 ; i<board.length ; i++){
        	for(int j = 0 ; j<board[i].length ; j++){
        		findWords(board, i, j, root, result);
        	}
        }
        return result;
    }
	
	public void findWords(char[][] board, int i, int j, TrieNode root, List<String> result){
		char cur = board[i][j];
		if(cur == '#' || root.next[cur-'a']==null) return;
		TrieNode next = root.next[cur-'a'];
		if(next.word != null){
			result.add(next.word);
			next.word = null;
		}
		
		board[i][j] = '#';
		if(i>0) findWords(board, i-1, j, next, result);
		if(j>0) findWords(board, i, j-1, next, result);
		if(i<board.length-1) findWords(board, i+1, j, next, result);
		if(j<board[0].length-1) findWords(board, i, j+1, next, result);
		board[i][j] = cur;
	}
	public TrieNode buildTrieNode(String[] words){
		TrieNode root = new TrieNode();
		for(String word : words){
			TrieNode cur = root;
			char[] array = word.toCharArray();
			for(char c : array){
				if(cur.next[c-'a'] == null){
					cur.next[c-'a'] = new TrieNode();
				}
				cur = cur.next[c-'a'];
			}
			cur.word = word;
		}
		return root;
		
	}
	private class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}
