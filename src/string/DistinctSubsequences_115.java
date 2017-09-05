package string;

/**
 * @author rale
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequences_115 {
	//O(n*m)空间复杂度
	public int numDistinct(String s, String t) {
		if(s==null || t==null) return 0;
		if(t.isEmpty()) return 1;
		int[][] temp = new int[t.length()+1][s.length()+1];
		for(int i = 0 ; i<s.length()+1 ; i++) temp[0][i] = 1;
		
        for(int i = 0; i<t.length() ; i++){
        	for(int j = 1 ; j<s.length()+1 ; j++){
        		if(t.charAt(i)==s.charAt(j-1)){
        			temp[i+1][j] = temp[i+1][j-1]+ temp[i][j-1];
        		}else{
        			temp[i+1][j] = temp[i+1][j-1];
        		}
        	}
        }
        return temp[t.length()][s.length()];
    }
	
	//O(m)空间复杂度
	public int numDistinct2(String s, String t) {
        int[] array = new int[s.length()+1];
		int prev = 1;
		for(int i = 0 ; i<s.length()+1 ; i++) array[i] = 1;
		for(int i = 0 ; i<t.length() ; i++){
			for(int j = 0 ; j<s.length()+1 ; j++){
                int temp = array[j];
				if(j==0) array[j] = 0;
				else if(t.charAt(i) == s.charAt(j-1)){
					array[j] = array[j-1]+prev; 
				}else{
					array[j] = array[j-1];
				}
                prev = temp;

			}
		}
		return array[s.length()];
    }
	
	public static void main(String[] args){
		DistinctSubsequences_115 d = new DistinctSubsequences_115();
		d.numDistinct("b", "b");
	}
	
}
