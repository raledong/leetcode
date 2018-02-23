package array;

/**
 * @author rale
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII_123 {
	
	public int maxProfit(int[] prices) {
		int days = prices.length;
		if(days==0) return 0;
		int[] maxProfitFromLeft = new int[days];
		int minLeft = prices[0], maxProfit = 0;
		for(int i = 1 ; i<days ; i++){
			if(prices[i] <= minLeft){
				minLeft = prices[i];
			}else{
				maxProfit = Math.max(prices[i] - minLeft, maxProfit);
			}
			maxProfitFromLeft[i] = maxProfit;
		}
		int result = 0, maxRight = prices[days-1];
		for(int j = days-2 ; j>=0 ; j--){
			if(prices[j] >= maxRight){
				maxRight = prices[j];
			}else{
				maxProfitFromLeft[j] += maxRight - prices[j]; 
			}
			result = Math.max(result, maxProfitFromLeft[j]);
		}
		return result;
    }
	
	public static void main(String[] args){
		BestTimetoBuyandSellStockIII_123 b = new BestTimetoBuyandSellStockIII_123();
		b.maxProfit(new int[]{
				3,2,6,5,0,3
		});
	}
}
