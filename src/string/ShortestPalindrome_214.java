package string;

/**
 * @author rale
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome_214 {
	
	//brute force
	//找到所有可能的以s.charAt(0)作为开头的回数
	public String shortestPalindrome(String s) {
		if(s.length()<=1) return s;
		char[] sArray = s.toCharArray();
		
		int firstLetter = s.charAt(0);
		int lastIndex = s.lastIndexOf(firstLetter);
		while(lastIndex != 0){
			if(isPalindrome(sArray, lastIndex)) break;
			lastIndex = s.lastIndexOf(firstLetter, lastIndex-1);
		}
		StringBuilder appendString = new StringBuilder(s.substring(lastIndex+1)).reverse();
		return appendString.toString() + s;
    }
	
	//减少判断回数的基数
	public String shortestPalindrome2(String s){
		if(s.length()<=1) return s;
		int i = 0;
		char[] sArray = s.toCharArray();
		for(int j = s.length()-1 ; j>=0 ; j--){
			if(sArray[i] == sArray[j]) i++;
		}
		if(i==s.length()) return s;
		return new StringBuilder(s.substring(i)).reverse() + shortestPalindrome(s.substring(0, i)) + s.substring(i);
	}
	public boolean isPalindrome(char[] sArray, int endIndex){
		int startIndex = 0 ;
		while(startIndex < endIndex && sArray[startIndex] == sArray[endIndex]){
			startIndex++;
			endIndex--;
		}
		return startIndex >= endIndex;
	}
	
	//KMP算法
	public String shortestPalindrome3(String s) 
    {
       if(s==null || s.length()==0) return "";
       if(s.length()==1) return s;
       String revs = new StringBuilder(s).reverse().toString();
        
       String splusrev = s + "#"+ revs;
       
       int num = processKMP(splusrev);
        
       return revs.substring(0,s.length()-num) + s; 
    }
    
    public int processKMP(String s)
    {
        int[] kmp = new int[s.length()];
        
        for(int i=1; i<s.length(); i++)
        {
            int j = kmp[i-1];
            while(j>0 && s.charAt(i)!=s.charAt(j))
            {
                j = kmp[j-1];
            }
            
            if(s.charAt(i)==s.charAt(j))
            {
                kmp[i] = j+1;
            }
        }
        return kmp[s.length()-1];
    }
	
	public static void main(String[] args){
		ShortestPalindrome_214 s = new ShortestPalindrome_214();
		System.out.println(s.shortestPalindrome("abb"));
	}
}
