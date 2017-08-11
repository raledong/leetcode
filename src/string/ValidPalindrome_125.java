package string;

/**
 * @author rale
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome_125 {
	 public boolean isPalindrome(String s) {
		 s = s.trim();
		 if(s.isEmpty()) return true;
		 s = s.toLowerCase();
		 char[] array = s.toCharArray();
		 int pointer1 = 0;
		 int pointer2 = s.length()-1;
		 while(pointer1<pointer2){
			 if(! ((array[pointer1]>='a'&&array[pointer1]<='z') || (array[pointer1]>='0'&&array[pointer1]<='9'))) pointer1++;
			 else if(! ((array[pointer2]>='a'&&array[pointer2]<='z') || (array[pointer2]>='0'&&array[pointer2]<='9'))) pointer2--;
			 else if(array[pointer1]!=array[pointer2]) return false;
			 else{
				 pointer1++;
				 pointer2--;
			 }
		 }
		return true;
	 }
	 
	 public static void main(String[] args){
		 ValidPalindrome_125 v = new ValidPalindrome_125();
		 v.isPalindrome("0P");
	 }
}
