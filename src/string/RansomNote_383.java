package string;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author rale
 *
 */
public class RansomNote_383 {

	public boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.isEmpty()) return true;
		if(ransomNote.length() > magazine.length()) return false;
		int p1 = 0, p2 = 0;
		int[] count = new int[26];
		int wordCount = 0;
		while(p1 < ransomNote.length() && p2 < ransomNote.length()) {
			char c1 = ransomNote.charAt(p1);
			char c2 = magazine.charAt(p2);
			if(++count[c1-'a'] == 1) {
				wordCount++;
			}
			if(--count[c2-'a'] == 0) {
				wordCount--;
			}
			
			p1++;
			p2++;
		}
		
		while(p2 < magazine.length()) {
			if(wordCount == 0) break;
			char c = magazine.charAt(p2);
			count[c-'a']--;
			if(count[c-'a'] == 0) {
				wordCount--;
			}
			p2++;
		}
		return wordCount == 0;
    }
	
	/**
	 * 记录杂志中该单词最近一次被引用的下标
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct2(String ransomNote, String magazine) {
        int len=ransomNote.length();
        int[] index = new int[128];
        for(int i = 0; i < len; i++){
            char cu=ransomNote.charAt(i);
            int result=magazine.indexOf(cu,index[cu]);
            if(result == -1){
                return false;
            }
            else{
                index[cu]=result + 1;   
            }   
        }
        return true;
    }
	public static void main(String[] args) {
		RansomNote_383 r = new RansomNote_383();
		r.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh");
	}
}
