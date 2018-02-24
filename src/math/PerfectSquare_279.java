package math;

/**
 * @author rale
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquare_279 {
	
	//暴力递归
	public int numSquares(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
        int sqrt = (int) Math.floor(Math.sqrt(n));
        int count = Integer.MAX_VALUE;
        while(sqrt>0){
        	int tmpCount = 0;
        	int copy = n;
        	do{
        		copy -= sqrt * sqrt;
        		tmpCount++;
        	}while(copy > sqrt * sqrt);
        	count = Math.min(count, tmpCount+numSquares(copy));
        	sqrt--;
        }
        return count;
    }
	
	public int numSquares_dp(int n){
		if(n<=1) return n;
		int[] min = new int[n+1];
		min[1] = 1;
		for(int i = 2 ; i<=n ; i++){
			int sqrt = (int)Math.floor(Math.sqrt(i));
			int tempMin = Integer.MAX_VALUE;
			while(sqrt-->0){
				tempMin = Math.min(tempMin, min[n-sqrt*sqrt]);
				sqrt--;
			}
			min[i] = tempMin;
		}
		return min[n];
	}
	
	public int numSquares_math(int n){
		if(isSquare(n)) return 1;
		 while ((n & 3) == 0) // n%4 == 0  
	        {
	            n >>= 2;  
	        }
	        if ((n & 7) == 7) // n%8 == 7
	        {
	            return 4;
	        }
	        
	        // Check whether 2 is the result.
	        int sqrt_n = (int)(Math.sqrt(n)); 
	        for(int i = 1; i <= sqrt_n; i++)
	        {  
	            if (isSquare(n - i*i)) 
	            {
	                return 2;  
	            }
	        }  
	        
	        return 3; 
	}
	
	public boolean isSquare(int n){
		int sqrt = (int) Math.floor(Math.sqrt(n));
		return sqrt * sqrt == n;
	}
}
