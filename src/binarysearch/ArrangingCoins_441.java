package binarysearch;

/**
 * @author rale
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * 
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins_441 {
	public int arrangeCoins(int n) {
		long rgt = (int) (Math.sqrt(n) * Math.sqrt(2) + 1);
		long lft = 0;
		while(lft <= rgt) {
			long mid = lft + (rgt -lft) / 2;
			long total = (mid + 1) * mid / 2;
			if(total <= n) {
				lft = mid + 1;
			}else {
				rgt = mid - 1;
			}
		}
		return (int)lft-1;
    }
	
	public static void main(String[] args) {
		ArrangingCoins_441 a = new ArrangingCoins_441();
		a.arrangeCoins(1804289383);
	}
}
