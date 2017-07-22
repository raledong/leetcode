package string;

/**
 * @author rale
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", "?*") ? true
isMatch("aab", "c*a*b") ? false
 */
public class WildcardMatching_44 {
	public boolean isMatch(String s, String p) {
		int sPointer=0, pPointer=0, matchIdx=-1, match=0;
		while(sPointer<s.length()){
			if(pPointer<p.length() && (p.charAt(pPointer)==s.charAt(sPointer) || p.charAt(pPointer)=='?')){
				sPointer++;
				pPointer++;
			}else if(pPointer<p.length() && p.charAt(pPointer)=='*'){
				matchIdx = pPointer;
				match = sPointer;
				pPointer++;
			}else if(matchIdx!=-1){
				pPointer = matchIdx+1;
				match++;
				sPointer = match;
			}else{
				return false;
			}
		}
		while(pPointer<p.length() && p.charAt(pPointer)=='*')pPointer++;
		return pPointer==p.length();
    }
	
	
}
