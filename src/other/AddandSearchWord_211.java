package other;

/**
 * @author rale
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z 
 * or 
 * .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * you may assume that all words are consist of lowercase letters a-z.
 */
public class AddandSearchWord_211 {
	
	public class Node{
		Node[] children = new Node[26];
		String item;
	}
	/** Initialize your data structure here. */
//    public WordDictionary() {
//        
//    }
	private Node root = new Node();
	public AddandSearchWord_211(){
		
	}
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node copy = root;
        for(char c : word.toCharArray()){
        	if(copy.children[c-'a']==null){
        		copy.children[c-'a'] = new Node();
        	}
        	copy = copy.children[c-'a'];
        }
        copy.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] word, int index, Node root){
    	if(index==word.length) return !root.item.equals("");
    	int num = word[index] - 'a';
    	if(word[index] != '.'){
    		return root.children[num]!=null && match(word, index+1, root.children[num]);
    	}else{
    		for(int i = 0; i<root.children.length ; i++){
    			if(root.children[i] != null){
    				if(match(word, index+1, root.children[i]));
    			}
    		}
    	}
    	return false;
    }
}
