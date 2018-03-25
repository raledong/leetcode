package other;

/**
 * @author rale
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits_338 {
	
	public int[] countBits(int num) {
        int[] res = new int[num+1];
        int cur = 1;
        while(cur <= num){
        	res[cur] = 1;
        	cur <<= 1;
        }
        
        cur = 1;
        for(int i = 1 ; i<=num ; i++){
        	if(res[i] > 0){
        		cur = i;
        	}else{
        		res[i] = res[i-cur] + 1;
        	}
        }
        return res;
    }
	
	public int[] countBits2(int num) {
	      int[] ans = new int[num + 1];
	      for (int i = 1; i <= num; ++i)
	        ans[i] = ans[i & (i - 1)] + 1;
	      return ans;
	  }
}
