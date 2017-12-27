package hashmap;

/**
 * @author rale
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings_205 {
	
	public boolean isIsomorphic(String s, String t) {
        char[] map1= new char[256];
        char[] map2 = new char[256];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        
        for(int i = 0 ; i<s1.length ; i++){
        	char c1 = s1[i];
        	char c2 = t1[i];
        	if(map1[c1]==0 && map2[c2]==0){
        		map1[c1] = c2;
        		map2[c2] = c1;
        	}else if(map1[c1]==c2 && map2[c2]==c1){
        		continue;
        	}else{
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args){
		IsomorphicStrings_205 i = new IsomorphicStrings_205();
		i.isIsomorphic("egg", "add");
	}
}
