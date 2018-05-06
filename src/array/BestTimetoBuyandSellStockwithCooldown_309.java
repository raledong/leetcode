package array;

/**
 * @author rale
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * 
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown_309 {
	
	public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int hasOneDoNothing = -prices[0];
        int hasOneSellIt = 0;
        int hasZeroDoNothing = 0;
        int hasZeroBuyOne = -prices[0];
        
        for(int i = 1 ; i<prices.length ; i++){
        	int tmp1 = hasOneDoNothing;
        	int tmp2 = hasOneSellIt;
        	int tmp3 = hasZeroDoNothing;
        	int tmp4 = hasZeroBuyOne;
        	
        	hasOneDoNothing = tmp1 > tmp4 ? tmp1 : tmp4;
        	hasOneSellIt = (tmp1 > tmp4 ? tmp1 : tmp4) + prices[i];
        	hasZeroDoNothing = tmp2 > tmp3 ? tmp2 : tmp3;
        	hasZeroBuyOne = tmp3 - prices[i];
        }
        
        return hasZeroDoNothing > hasOneSellIt ? hasZeroDoNothing : hasOneSellIt;
    }
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockwithCooldown_309 b = new BestTimetoBuyandSellStockwithCooldown_309();
		b.maxProfit(new int[]{1, 2, 3, 0, 2});
	}
}
