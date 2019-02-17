package dynamicprogramming;

import java.util.Arrays;

/**
 * @author rale
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherorLowerII_375 {
	public int getMoneyAmount(int n) {
        int[][] tmp = new int[n+1][n+1];
        for(int[] row: tmp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return getMoneyAmount(n, 1, n, tmp);
    }
	
	public int getMoneyAmount(int n, int lft, int rgt, int[][] tmp) {
		if(lft>=rgt) return 0;
		if(tmp[lft][rgt] != Integer.MAX_VALUE) return tmp[lft][rgt];
		for(int i = lft ; i<=rgt ; i++) {
			tmp[lft][rgt] = Math.min(tmp[lft][rgt], Math.max(i + getMoneyAmount(n, lft, i-1, tmp), i + getMoneyAmount(n, i+1, rgt, tmp)));
		}
		return tmp[lft][rgt];
	}
	
	
	public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return getCost(dp, 1, n);
    }
    
    private int getCost(int[][] dp, int start, int end) {
        if(dp[start][end] != 0) return dp[start][end];
        if(start >= end) return 0;
        if(start == end - 1) return start;
        if(start == end - 2) return start + 1;
        
        int result = Integer.MAX_VALUE;
        int mid = (start + end) >>> 1;
        int left;
        int right;
        while(mid < end) {
            left = getCost(dp, start, mid - 1);
            right = getCost(dp, mid + 1, end);
            result = Math.min(result, mid + Math.max(left, right));
            if(left >= right) break;
            mid++;
        } 
        dp[start][end] = result;
        return result;
    }
    
    public int getMoneyAmount3(int n) {
    	int[][] dp = new int[n+1][n+1];
    	for(int i = 2 ; i<=n ; i++) {
    		for(int j = i-1 ; j>0 ; j--) {
    			int min = Integer.MAX_VALUE;
    			for(int k = j+1 ; k<i ; k++) {
    				min = Math.min(min, k + Math.max(dp[j][k-1], dp[k+1][i]));
    			}
    			dp[j][i] = j + 1 == i ? j : min;
    		}
    	}
    	return dp[1][n];
    	
    }
    
    public static void main(String[] args) {
    	GuessNumberHigherorLowerII_375 g = new GuessNumberHigherorLowerII_375();
    	g.getMoneyAmount3(3);
    }
    
    
}
