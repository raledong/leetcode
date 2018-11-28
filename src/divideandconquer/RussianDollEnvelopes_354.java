package divideandconquer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * 
 * Note:
 * Rotation is not allowed.
 * 
 * Example:
 * 
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3 
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * @author rale
 *
 */
public class RussianDollEnvelopes_354 {
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 
			       || envelopes[0] == null || envelopes[0].length != 2)
			        return 0;
			    Arrays.sort(envelopes, new Comparator<int[]>(){
			        public int compare(int[] arr1, int[] arr2){
			            if(arr1[0] == arr2[0])
			                return arr2[1] - arr1[1];
			            else
			                return arr1[0] - arr2[0];
			       } 
			    });
			    int dp[] = new int[envelopes.length];
			    int len = 0;
			    for(int[] envelope : envelopes){
			        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			        if(index < 0)
			            index = -(index + 1);
			        dp[index] = envelope[1];
			        if(index == len)
			            len++;
			    }
			    return len;
    }
	
	public int maxEnvelopes2(int[][] envelopes) {
	    if (   envelopes           == null
	        || envelopes.length    == 0
	        || envelopes[0]        == null
	        || envelopes[0].length == 0){
	        return 0;    
	    }
	    
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        @Override
	        public int compare(int[] e1, int[] e2){
	            return Integer.compare(e1[0], e2[0]);
	        }
	    });
	    
	    int   n  = envelopes.length;
	    int[] dp = new int[n];
	    
	    int ret = 0;
	    for (int i = 0; i < n; i++){
	        dp[i] = 1;
	        
	        for (int j = 0; j < i; j++){
	            if (   envelopes[i][0] > envelopes[j][0]
	                && envelopes[i][1] > envelopes[j][1]){
	                dp[i] = Math.max(dp[i], 1 + dp[j]);    
	            }
	        }
	        
	        ret = Math.max(ret, dp[i]);
	    }
	    return ret;
	}
	public static void main(String[] args) {
		RussianDollEnvelopes_354 r = new RussianDollEnvelopes_354();
		int value =r.maxEnvelopes(new int[][]{
			{2, 100},
			{3, 200},
			{4, 300},
			{5, 500},
			{5, 400},
			{5, 250},
			{6, 370},
			{6, 360},
			{7, 380}
		});
		System.out.println(value);
	}
}
