package string;

/**
 * @author rale
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString_97 {
	
	//超时啊 run-time stack吃不消啊
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0,0,0);
    }
	
	public boolean isInterleave(String s1, String s2, String s3, int pointer1, int pointer2, int pointer3){
		if(pointer1==s1.length() && pointer2==s2.length())return pointer3 == s3.length();
		if(pointer1<s1.length() && s1.charAt(pointer1)==s3.charAt(pointer3) && isInterleave(s1,s2,s3,pointer1+1, pointer2, pointer3+1)) return true;
		if(pointer2<s2.length() && s2.charAt(pointer2)==s3.charAt(pointer3) && isInterleave(s1,s2,s3,pointer1, pointer2+1, pointer3+1)) return true;
		return false;
	}
	
	//优化堆栈
	public boolean isInterleave2(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0,0,0, new boolean[s1.length()+1][s2.length()+1]);
        
    }
	
	public boolean isInterleave(String s1, String s2, String s3, int pointer1, int pointer2, int pointer3, boolean[][] isInvalid){
		if(isInvalid[pointer1][pointer2]) return false;
		if(pointer3 == s3.length())return true;
		boolean isValid = pointer1<s1.length() && s1.charAt(pointer1)==s3.charAt(pointer3) && isInterleave(s1,s2,s3,pointer1+1,pointer2, pointer3+1, isInvalid)
				|| pointer2<s2.length() && s2.charAt(pointer2)==s3.charAt(pointer3) && isInterleave(s1,s2,s3,pointer1,pointer2+1,pointer3+1,isInvalid);
		if(!isValid) isInvalid[pointer1][pointer2]=true;
		return isValid;
	}
	
	//boolean[][] 记录在(i,j)位置上是否可以和(i-1,j),(i,j-1)上的数组组成字符串
	public boolean isInterleave3(String s1, String s2, String s3){
		if ((s1.length()+s2.length())!=s3.length()) return false;
		boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];
		matrix[0][0] = true;
		for(int i = 1 ; i<s1.length()+1 ; i++){
			matrix[0][i] = matrix[0][i-1] && s1.charAt(i-1)==s3.charAt(i-1);
		}
		for(int i = 1 ; i<s2.length()+1 ; i++){
			matrix[i][0] = matrix[i-1][0] && s2.charAt(i-1)==s3.charAt(i-1);
		}
		
		for(int i = 1 ; i<matrix.length ; i++){
			for(int j = 1 ; j<matrix[0].length ; j++){
				matrix[i][j] = (matrix[i-1][j] && s2.charAt(i-1)==s3.charAt(i+j-1))
						||(matrix[i][j-1] && s1.charAt(j-1)==s3.charAt(i+j-1));
			}
		}
		return matrix[s2.length()][s1.length()];
	}
}
