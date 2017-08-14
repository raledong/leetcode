package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author rale
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * 	["hit","hot","dot","dog","cog"],
 * 	["hit","hot","lot","log","cog"]
 * ]
 * 
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class WordLadderII_126 {
	Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	List<List<String>> result = new ArrayList<List<String>>();
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> isVisited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        boolean shouldFinish = false;
        if(beginWord!=null){
        	q.offer(beginWord);
        	while(!q.isEmpty() && !shouldFinish){
        		int size = q.size();
        		Set<String> temp = new HashSet<String>();
        		for(int i = 0 ; i<size ; i++){
        			String current = q.poll();
        			char[] currentS = current.toCharArray();
        			for(int j = 0 ; j<currentS.length; j++){
        				char old = currentS[j];
        				
        				for(char c = 'a' ; c<='z' ; c++){
        					currentS[j] = c;
        					String target = String.valueOf(currentS);
        					if(!isVisited.contains(target) && wordList.contains(target) && !target.equals(beginWord)){
        						if(map.get(current)==null){
        							Set<String> currentSet = new HashSet<String>();
        							currentSet.add(target);
        							map.put(current, currentSet);
        						}else{
        							map.get(current).add(target);
        						}
        						temp.add(target);
        						if(!q.contains(target)) q.offer(target);
            					if(target.equals(endWord)) shouldFinish = true;
        					}
        				}
        				
        				currentS[j] = old;
        			}
        		}
        		isVisited.addAll(temp);
        	}
        }
        
        generatePath(beginWord, endWord, new ArrayList<String>());
        return result;
    }
	
//	public void generatePath(Map<String, Set<String>> map, String currentWord, String beginWord, List<String> current,List<List<String>> result){
//		if(currentWord.equals(beginWord)){
//			current.add(0,currentWord);
//			result.add(new ArrayList<String>(current));
//			current.remove(0);
//		}else{
//			Set<String> set = map.get(currentWord);
//			if(set!=null){
//				current.add(0,currentWord);
//				for(String s : set){
//					generatePath(map, s, beginWord,current, result);
//				}	
//				current.remove(0);
//			}	
//		}
//	}
	
	public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for(int i = 0 ; i<wordList.size() ; i++){
        	ladder.put(wordList.get(i), Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        Queue<String> q = new LinkedList<String>();
        int minStep = Integer.MAX_VALUE;
        if(beginWord!=null){
        	q.offer(beginWord);
        	while(!q.isEmpty()){
        		String current = q.poll();
        		int step = ladder.get(current)+1;
        		if(step>minStep) break;
        		for (int i = 0; i < current.length(); i++){
        			StringBuilder sb = new StringBuilder(current);
        			for (char ch='a';  ch <= 'z'; ch++){
        				sb.setCharAt(i, ch);
        				String sbs = sb.toString();
        				if(ladder.containsKey(sbs)){
        					if(step>ladder.get(sbs)) continue;
        					else if(step<ladder.get(sbs)){
        						q.add(sbs);
        						ladder.put(sbs, step);
        					}
        					if(map.containsKey(current)){
        						map.get(current).add(sbs);
        					}else{
        						Set<String> list= new HashSet<String>();
    					    	list.add(sbs);
    					    	map.put(current,list);
        					}
        					if(sbs.equals(endWord)) minStep = step;
        				}
        			}
        		}
        	}
        }
        
        generatePath(beginWord, endWord, new ArrayList<String>());
        return result;
    }
	public void generatePath(String currentWord, String endWord, List<String> current){
		current.add(currentWord);
		if(currentWord.equals(endWord)){
			result.add(new ArrayList<String>(current));
		}else{
			Set<String> set = map.get(currentWord);
			if(set!=null){
				for(String s : set){
					generatePath(s, endWord,current);
				}	
			}	
		}
		current.remove(current.size()-1);
	}
	public static void main(String[] args){
		WordLadderII_126 w = new WordLadderII_126();
		w.findLadders("hit", "cog" , new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog")));
//		w.findLadders("a", "c", new ArrayList<String>(Arrays.asList("a","b","c")));
//		w.findLadders("hot", "dog", new ArrayList<String>(Arrays.asList("hot","dog","dot")));
	}
}
