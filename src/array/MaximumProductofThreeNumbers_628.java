package array;

/**
 * @author rale
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductofThreeNumbers_628 {
	
	public int maximumProduct(int[] nums) {
		//整个数组中三个最大的数字
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int num : nums){
        	if(num > max1){
        		max3 = max2;
        		max2 = max1;
        		max1 = num;
        	}else if(num > max2){
        		max3 = max2;
        		max2 = num;
        	}else if(num > max3){
        		max3 = num;
        	}
        	
        	if(num < min1){
        		min2 = min1;
        		min1 = num;        				
        	}else if(num < min2){
        		min2 = num;
        	}
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
        
    }
}
