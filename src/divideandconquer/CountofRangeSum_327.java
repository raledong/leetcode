package divideandconquer;

/**
 * @author rale
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * 
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * 
 * Example:
 * 
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3 
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class CountofRangeSum_327 {
	
	/**
	 * 计算[i,j)之间的数字和，判断该值是否处于区间之间
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        for(int i = 0 ; i<nums.length ; i++) {
        	sums[i+1] = sums[i] + nums[i];
        }
        
        int count = 0;
        for(int i = 0 ; i<nums.length ; i++) {
        	for(int j = i+1 ; j<=nums.length ; j++) {
        		if(sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper) {
        			count++;
        		}
        	}
        }
        return count;
    }
	/**
	 * 利用归并排序
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public int countRangeSum2(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		for(int i = 0 ; i<nums.length ; i++) {
        	sums[i+1] = sums[i] + nums[i];
        }
		return mergeCountRangeSum(sums, 0, nums.length+1, lower, upper);
	}
	
	public int mergeCountRangeSum(long[] sums, int start, int end, int lower, int upper) {
		if(end - start <= 1) return 0;
		int mid = (start + end) / 2;
		int count = mergeCountRangeSum(sums, start, mid, lower, upper) 
				+ mergeCountRangeSum(sums, mid, end, lower, upper);
		long[] sortedSumsCache = new long[end-start];
		int firstLargerThanUpper = mid, firstLargerThanLower = mid, indexOfRightHalf = mid;
		for(int i = start, sortedSumsIndex = 0; i < mid ; i++, sortedSumsIndex++) {
			while(firstLargerThanUpper < end && sums[firstLargerThanUpper] - sums[i] <= upper)  firstLargerThanUpper++;
			while(firstLargerThanLower < end && sums[firstLargerThanLower] - sums[i] <lower) firstLargerThanLower++;
			while(indexOfRightHalf < end && sums[indexOfRightHalf] < sums[i]) sortedSumsCache[sortedSumsIndex++] = sums[indexOfRightHalf++];
			sortedSumsCache[sortedSumsIndex] = sums[i];
			count += firstLargerThanUpper - firstLargerThanLower;
		}
		System.arraycopy(sortedSumsCache, 0, sums, start, indexOfRightHalf - start);
	    return count;
	}
	
	public int countRangeSum3(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		for(int i = 0 ; i<nums.length ; i++) {
        	sums[i+1] = sums[i] + nums[i];
        }
		long[] sortedSums = new long[nums.length + 1];
		return mergeCountRangeSum(sums, sortedSums, 0, nums.length+1, lower, upper);
	}
	
	public int mergeCountRangeSum(long[] sums,long[]  sortedSums, int start, int end, int lower, int upper) {
		if(end - start <= 1) return 0;
		int mid = (start + end) / 2;
		int count = mergeCountRangeSum(sums, start, mid, lower, upper) 
				+ mergeCountRangeSum(sums, mid, end, lower, upper);
		int firstLargerThanUpper = mid, firstLargerThanLower = mid, indexOfRightHalf = mid;
		for(int i = start, sortedSumsIndex = start; i < mid ; i++, sortedSumsIndex++) {
			while(firstLargerThanUpper < end && sums[firstLargerThanUpper] - sums[i] <= upper)  firstLargerThanUpper++;
			while(firstLargerThanLower < end && sums[firstLargerThanLower] - sums[i] <lower) firstLargerThanLower++;
			while(indexOfRightHalf < end && sums[indexOfRightHalf] < sums[i]) sortedSums[sortedSumsIndex++] = sums[indexOfRightHalf++];
			sortedSums[sortedSumsIndex] = sums[i];
			count += firstLargerThanUpper - firstLargerThanLower;
		}
		System.arraycopy(sortedSums, start, sums, start, indexOfRightHalf - start);
	    return count;
	}
}
