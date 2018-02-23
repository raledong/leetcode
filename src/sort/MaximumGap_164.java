package sort;

/**
 * @author rale
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap_164 {
	
	public int maximumGap(int[] nums) {
        int count = nums.length;
        if(count < 2) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        
        int minGap = (int)Math.ceil((max - min) * 1.0 / (count - 1));
        if(minGap==0) return minGap;
        int[] minBucket = new int[count];
        int[] maxBucket = new int[count];
        for(int i = 0 ; i<count ; i++){
        	minBucket[i] = Integer.MAX_VALUE;
        	maxBucket[i] = Integer.MIN_VALUE;
        }
        
        for(int num : nums){
        	int index = (num - min) / minGap;
        	minBucket[index] = Math.min(minBucket[index], num);
        	maxBucket[index] = Math.max(maxBucket[index], num);
        }
        
        int prev = maxBucket[0];
        int maxGap = minGap;
        for(int i = 1 ; i<count ; i++){
        	if(minBucket[i] > maxBucket[i]) continue;
        	maxGap = Math.max(minBucket[i] - prev, maxGap);
        	prev = maxBucket[i];
        }
        
        return maxGap;
    }
	
	public static void main(String[] args){
		MaximumGap_164 m = new MaximumGap_164();
		m.maximumGap(new int[]{
				15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740
		});
	}
	
}
