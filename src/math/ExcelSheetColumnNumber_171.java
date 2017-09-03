package math;

/**
 * @author rale
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber_171 {
	 public int titleToNumber(String s) {
		 if(s==null || s.length()==0) return 0;
		 char[] array = s.toCharArray();
		 int index = 1;
		 int result = 0;
		 for(int i = array.length-1 ; i>=0 ; i--){
			 result += (array[i]-'A'+1)*index;
			 index *= 26;
		 }
		 return result;
	 }
	 
	 /**
	  * 就像是二十六进制转向十进制
	  * @param s
	  * @return
	  */
	 public int titleToNumber2(String s) {
	        int lenth = s.length();
	        int res = 0;
	        for(int i = 0; i < lenth; i++){
	            res = res * 26 + (s.charAt(i) - 'A'+ 1);
	        }
	        return res;
	 }
}
