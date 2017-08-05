package string;

/**
 * @author rale
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance_72 {
	
	//steps[i][j]表示将word1[0...i]转化为word2[0...j]所需要的最小步数
	public int minDistance(String word1, String word2) {
		if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        int[][] steps = new int[word1.length()+1][word2.length()+1];
		for(int i = 0 ; i<=word1.length() ; i++){
			for(int j = 0 ; j<=word2.length() ; j++){
				if(i==0){
					steps[i][j] = j;
				}else if(j==0){
					steps[i][j] = i;
				}else if(word1.charAt(i-1) == word2.charAt(j-1)){
					steps[i][j] = steps[i-1][j-1];
 				}else{
 					steps[i][j] = Math.min(Math.min(steps[i][j-1]+1, steps[i-1][j-1]+1), steps[i-1][j]+1);
 				}
					
			}
		}
		return steps[word1.length()][word2.length()];
    }
	
	public int minDistance2(String word1, String word2){
		if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
		int[] steps = new int[word2.length()+1];
        for(int j = 0 ; j<=word2.length() ; j++){
            steps[j] = j;
        }
		for(int i = 1 ; i<=word1.length() ; i++){
			int pre = steps[0];
            steps[0] = i;
			for(int j = 1 ; j<=word2.length() ; j++){
				int temp = steps[j];
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					steps[j] = pre;
				}else{
					steps[j] = Math.min(pre+1, Math.min(steps[j]+1, steps[j-1]+1));
				}
				pre = temp;
			}

		}
		return steps[word2.length()];
	}
}
