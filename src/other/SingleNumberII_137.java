package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII_137 {

	public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i<nums.length ; i++){
        	if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
        	else map.put(nums[i], 1);
        }
        int singleNumber = 0;
        for(Integer i : map.keySet()){
        	if(map.get(i)==1){singleNumber = i;break;}
        }
        return singleNumber;
    }
	
	public int singleNumber2(int[] nums){
		Arrays.sort(nums);;
		for(int i = 0 ; i<nums.length-3 ; i+=3){
			if(nums[i]!=nums[i+2]) return nums[i];
		}
		return nums[nums.length-1];
	}
	
	/**
	 * The code seems tricky and hard to understand at first glance.
	 * However, if you consider the problem in Boolean algebra form, everything becomes clear.
	 * 
	 * What we need to do is to store the number of '1's of every bit. Since each of the 32 bits follow the same rules, we just need to consider 1 bit. We know a number appears 3 times at most, so we need 2 bits to store that. Now we have 4 state, 00, 01, 10 and 11, but we only need 3 of them.
	 * 
	 * In this solution, 00, 01 and 10 are chosen. Let 'ones' represents the first bit, 'twos' represents the second bit. Then we need to set rules for 'ones' and 'twos' so that they act as we hopes. The complete loop is 00->10->01->00(0->1->2->3/0).
	 * For 'ones', we can get 'ones = ones ^ A[i]; if (twos == 1) then ones = 0', that can be tansformed to 'ones = (ones ^ A[i]) & ~twos'.
	 * Similarly, for 'twos', we can get 'twos = twos ^ A[i]; if (ones* == 1) then twos = 0' and 'twos = (twos ^ A[i]) & ~ones'. Notice that 'ones*' is the value of 'ones' after calculation, that is why twos is
	 * calculated later.
	 */
	public int singleNumber3(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
}
