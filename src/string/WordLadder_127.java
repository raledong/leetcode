package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rale
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class WordLadder_127 {
	 int minStep = Integer.MAX_VALUE;
	 
	 //方法一：递归 超时
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		 ladderLengthR(beginWord, endWord, wordList, 0);
		 return minStep==Integer.MAX_VALUE?0:minStep+1;
	 }
	 
	 public void ladderLengthR(String beginWord, String endWord, List<String> wordList, int currentSteps){
		 if(beginWord.equals(endWord)) {minStep = Math.min(currentSteps, minStep); return;}
		 
		 for(int i = 0 ; i<wordList.size() ; i++){
			 if(canTransform(beginWord, wordList.get(i))){
				 String temp = wordList.remove(i);
				 ladderLengthR(temp, endWord, wordList, currentSteps+1);
				 wordList.add(i, temp);
			 }
		 }
	 }
	 
	 public boolean canTransform(String word1, String word2){
		 for(int i = 0, count=0 ; i<word1.length() ; i++){
			 if(word1.charAt(i)!=word2.charAt(i) && ++count>1) return false;
		 }
		 return true;
	 }
	 
	 //方法二：队列
	 public int ladderLength2(String beginWord, String endWord, List<String> wordList){
		 Queue<String> q = new LinkedList<String>();
		 q.add(beginWord);
		 int steps = 0;
		 while(!q.isEmpty()){
			 int size = q.size();
			 for(int i = 0 ;i<size ; i++){
				 String temp = q.poll();
				 if(temp.equals(endWord)){return steps+1;}
				 for(Iterator<String> iterator = wordList.iterator() ; iterator.hasNext();){
					 String current = iterator.next();
					 if(canTransform(current, temp)){
						 iterator.remove();
						 q.offer(current);
					 }
				 }
			 }
            steps++;

		 }
		 return 0;
	 }
	 
	 
	 public static void main(String[] args){
		 WordLadder_127 w = new WordLadder_127();
		 w.ladderLength2("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog")));
	 }
}
