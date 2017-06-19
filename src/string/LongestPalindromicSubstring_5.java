package string;

/**
 * @author rale
 * 需要重新写一遍
 *
 *Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 *Example:
 *Input: "babad"
 *Output: "bab"
 *
 *Note: "aba" is also a valid answer.
 *
 *Example:
 *
 *Input: "cbbd"
 *
 *Output: "bb"
 *
 *后记：
 *遍历的方法：
 *1.头指针加尾指针
 *2.指针加上当前长度
 *需要注意的，试着去考虑抽象情况下不可能发生的情况，从而排除多余的遍历
 */
public class LongestPalindromicSubstring_5 {

	//提供头尾指针，判断是否是回数
	public String longestPalindrome(String s) {
		StringBuilder result = new StringBuilder();
		int resultLength = 0;
		
        StringBuilder temp = new StringBuilder();
        for(int i = 0 ; i<s.length()-resultLength ; i++){
        	
        	for(int j = s.lastIndexOf(s.charAt(i)) ; j>=i+resultLength ; j = s.substring(0, j).lastIndexOf(s.charAt(i))){
        		temp = new StringBuilder(s.substring(i, j+1));
    			if(temp.toString().equals(temp.reverse().toString())){
    				result = temp;
    				resultLength = temp.length();
    				break;
    			}	
        	}
        }
        return result.toString();
    }
	
	//只使用尾指针，头指针通过长度进行判断
	public String longestPalindrome2(String s) {
		StringBuilder result = new StringBuilder();
		int curLength = 0;
		
        for(int i = 0 ; i<s.length() ; i++){
        	if(isPalindromic(s, i-curLength-1, i)){
        		result = new StringBuilder(s.substring(i-curLength-1, i+1));
        		curLength += 2;
        	}else if(isPalindromic(s, i-curLength, i)){
        		result = new StringBuilder(s.substring(i-curLength, i+1));
        		curLength += 1;
        	}
        }
        return result.toString();
    }
	public boolean isPalindromic(String s, int start, int end){
		if(start<0){
			return false;
		}
		while(start<end){
			if(s.charAt(start++)!=s.charAt(end--)) return false; 
		}
		return true;
	}
	
	//由中间至两边寻找最大回数
	private int lo, maxLen;
	public String longestPalindrome3(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	public static void main(String[] args){
		LongestPalindromicSubstring_5 l = new LongestPalindromicSubstring_5();
		System.out.println(l.longestPalindrome("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));
	}
}
