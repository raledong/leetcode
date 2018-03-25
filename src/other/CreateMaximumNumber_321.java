package other;

/**
 * @author rale
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. 
 * The relative order of the digits from the same array must be preserved. 
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 */
public class CreateMaximumNumber_321 {
	 
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
			//结果集
	        int[] result = new int[k];
	        int maxCountOfNumFromNums1 = Math.min(nums1.length, k);
	        for(int i = Math.max(0, k - maxCountOfNumFromNums1) ; i<=Math.min(k, nums2.length) ; i++){
	        	int j = k - i;
	        	int[] res1 = getMaxSubarray(nums1, j);
	        	int[] res2 = getMaxSubarray(nums2, i);
	        	int[] mergeRes = new int[k];
	        	
	        	int index = 0,
	        			index1 = 0,
	        			index2 = 0;
	        	while(index1<j && index2<i){
	        		if(compare(res1, index1, res2, index2)){
	        			mergeRes[index++] = res1[index1++];
	        		}else{
	        			mergeRes[index++] = res2[index2++];
	        		}
	        	}
	        	while(index1<j){
	        		mergeRes[index++] = res1[index1++];
	        	}
	        	while(index2<i){
	        		mergeRes[index++] = res2[index2++];
	        	}
	        	
	        	if(compare(mergeRes,0, result, 0)){
	        		result = mergeRes;
	        	}
	        }
	        return result;
	    }
		
		public boolean compare(int[] nums1, int index1, int[] nums2, int index2){
			for( ; index1<nums1.length && index2<nums2.length ; index1++, index2++){
				if(nums1[index1] > nums2[index2]) return true;
				if(nums1[index1] < nums2[index2]) return false;
			}
			return index1 < nums1.length;
		}
		public int[] getMaxSubarray(int[] nums, int count){
			int[] res = new int[count];
			int len = 0;
			int numLength  = nums.length;
			for(int i = 0 ; i<nums.length ; i++){
				while(len>0 && len + numLength - i > count && res[len-1] < nums[i]){
					len--;
				}
				if(len < count){
					res[len++] = nums[i];
				}
			}
			return res;
		}
}
