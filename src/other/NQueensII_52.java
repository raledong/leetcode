package other;

public class NQueensII_52 {

	public int totalNQueens(int n) {
		boolean[] leftCordinal = new boolean[n*2-1], 
				  rightCordinal= new boolean[n*2-1], 
				  vertical = new boolean[n];
		int result = 0;
		return totalNQueens(0, n, result, vertical, leftCordinal, rightCordinal);
    }
	
	public int totalNQueens(int current, int n, int result, boolean[] vertical, boolean[] leftCordinal, boolean[] rightCordinal){
		if(current == n){
			return ++result;
		}
		
		for(int i = 0 ; i<n ; i++){
			if(vertical[i] || leftCordinal[i+current] || rightCordinal[i-current+n-1]){
				continue;
			}
			vertical[i] = true;
			leftCordinal[i+current] = true;
			rightCordinal[i-current+n-1] = true;
			result = totalNQueens(current+1, n, result, vertical, leftCordinal, rightCordinal);
			vertical[i] = false;
			leftCordinal[i+current] = false;
			rightCordinal[i-current+n-1] = false;
		}
		return result;
	}
	
	public static void main(String[] args){
		NQueensII_52 n = new NQueensII_52();
		System.out.println(n.totalNQueens(5));
	}
	
}
