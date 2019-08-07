package string;

/**
 * @author rale
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * 
 * Example 1:
 * 
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * Input: "aba"
 * Output: False
 * 
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern_459 {
	
	public boolean repeatedSubstringPattern(String s) {
		int length = s.length();
		//i为子字符串长度
		for(int i = length / 2 ; i>=1 ; i--) {
			if(length % i == 0) {
				//重复的次数
				int repeatCount = length / i;
				//假设的重复的子字符串
				String subString = s.substring(0, i);
				int j = 1;
				for( ; j<repeatCount ; j++) {
					//一旦有一个子字符串不等，就可以退出比较
					if(!subString.equals(s.substring(j * i, (j + 1) * i))){
						break;
					}
				}
				//达到重复次数
				if(j == repeatCount) {
					return true;
				}
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		RepeatedSubstringPattern_459 r = new RepeatedSubstringPattern_459();
		r.repeatedSubstringPattern("ababab");
	}
}
