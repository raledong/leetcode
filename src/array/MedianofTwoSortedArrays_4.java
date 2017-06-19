package array;

/**
 * @author rale
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if(total == 0){
        	return 0;
        }
        if(m==total){
        	return m%2==0 ? (nums1[m/2] + nums1[m/2-1]) * 1.0 / 2 : nums1[m/2];
        }
        if(n==total){
        	return n%2==0 ? (nums2[n/2] + nums2[n/2-1]) * 1.0 / 2 : nums2[n/2];
        }
        int mid = total / 2;
        int pointer1 = m/2, pointer2 = n/2;
        int result;
        while(pointer1 != 0 || pointer2 != 0){
        	if(nums1[pointer1] > nums2[pointer2]){
        		int realIndex = pointer1 + pointer2 + 1;
        		if(realIndex == mid){
        			result = pointer1;
        			break;
        		}
        		pointer1 = (pointer1 - 1) / 2;
        	}else if(nums1[pointer1] < nums2[pointer2]){
        		int realIndex = pointer1 + pointer2 + 1;
        	}
        }
        return 0;
    }
}
