package bitmanipulation;

public class HammingDistance_461 {

	public int hammingDistance(int x, int y) {
		int diff = x ^ y;
		int result = 0;
		while(diff != 0) {
			result += diff & 1;
			diff >>>= 1;
		}
		return result;
    }
}
