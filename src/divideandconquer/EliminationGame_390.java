package divideandconquer;

public class EliminationGame_390 {
	public int lastRemaining(int n) {
        return lastRemaining(n, true);
    }
	
	public int lastRemaining(int n, boolean left) {
		if(n == 1) {
			return 1;
		}
		if(n % 2 == 1) {
			return lastRemaining(n / 2, !left) * 2;
		}else{
			if( left ) {
				return lastRemaining(n/2, !left) * 2;
			}else {
				return lastRemaining(n/2, !left) * 2 -1;
			}
		}
	}
	
	public int lastRemaining2(int n) {
        return n == 1 ? 1 : (1 + n / 2 - lastRemaining2(n/2)) * 2;
    }
	
}
