package math;

/**
 * @author rale
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False

 */
public class ValidPerfectSquare_367 {
	 public boolean isPerfectSquare(int num) {
		 int left = 0, right = num;
		 while(left<=right){
			 int mid = (left + right) / 2;
			 if(num * 1.0 / mid == mid) return true;
			 else if(num * 1.0 / mid > mid) left = mid+1;
			 else right = mid - 1;
		 }
		 return false;
	 }
}
