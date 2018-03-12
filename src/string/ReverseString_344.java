package string;

/**
 * @author rale
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString_344 {
	public String reverseString(String s) {
		char[] array = s.toCharArray();
		int left = 0,
				right = array.length-1;
		while(left < right){
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
		return String.valueOf(array);
    }
}
