package array;

/**
 * @author rale
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0){
			nums1 = nums2;
			return;
		}
		
		//nums1的指针
		int pointer1 = m-1 ;
		//nums2的指针
		int pointer2 = n-1 ;
		for(int j = m+n-1 ; pointer1>=0 && pointer2>=0 && j>pointer1 ; j--){
			if(nums2[pointer2] >= nums1[pointer1]){
				nums1[j] = nums2[pointer2--];
			}else{
				nums1[j] = nums1[pointer1--];
			}
		}
		while(pointer2>=0){
			nums1[pointer2] = nums2[pointer2];
			pointer2--;
		}
    }
	
	public static void main(String[] args){
		MergeSortedArray_88 m = new MergeSortedArray_88();
		m.merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);
	}
	
	
}
