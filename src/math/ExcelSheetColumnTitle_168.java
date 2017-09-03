package math;

/**
 * @author rale
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

 */
public class ExcelSheetColumnTitle_168 {
	String[] dictionary = new String[]{"A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z"};
	public String convertToTitle(int n) {
		if(n==0) return "";
		StringBuilder result = new StringBuilder();
		do{
			n--;
			result.append(dictionary[n%26]);
        	n/=26;
		}while(n!=0);
        return result.reverse().toString();
    }
}
