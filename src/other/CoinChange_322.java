package other;

import java.util.Arrays;

/**
 * @author rale
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange_322 {
	public int coinChange(int[] coins, int amount) {
		if(amount==0) return 0;
        Arrays.sort(coins);
        if(coins==null || coins.length==0 || amount < coins[0]) return -1;
        int[] result = new int[amount+1];
        for(int i = coins[0] ; i<=amount; i++){
        	int tmp = Integer.MAX_VALUE;
        	for(int j = 0 ; j<coins.length ; j++){
        		int remain = i-coins[j];
        		if(remain < 0) continue;
        		else if(remain==0 || result[remain]!=0){
        			tmp = Math.min(tmp, result[remain]+1);
        		}
        	}
        	result[i] = tmp==Integer.MAX_VALUE ? 0 : tmp;
        }
        return result[amount] == 0 ? -1 : result[amount];
    }
	
	private int[] cache;
	public int coinChange2(int[] coins, int amount){
		cache = new int[amount];
		return coinChangeRecursive(coins, amount);
	}
	
	public int coinChangeRecursive(int[] coins, int amount){
		if(amount<0) return -1;
		if(amount==0) return 0;
		if(cache[amount-1] != 0) return cache[amount-1];
		int min = Integer.MAX_VALUE;
		for(int coin : coins){
			int res = coinChangeRecursive(coins, amount-coin);
			if(res>=0 && res<min){
				min = res+1;
			}
		}
		cache[amount-1] = min==Integer.MAX_VALUE ? -1 : min;
		return cache[amount-1];
	}
	
	public static void main(String[] args){
		CoinChange_322 c = new CoinChange_322();
		c.coinChange(new int[]{474,83,404,3}, 264);
	}
}
