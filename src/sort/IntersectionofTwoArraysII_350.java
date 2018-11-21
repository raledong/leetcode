package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII_350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int firstPointer = 0, secondPointer = 0;
		List<Integer> result = new ArrayList<Integer>();
		while(firstPointer< nums1.length && secondPointer < nums2.length) {
			if(nums1[firstPointer] == nums2[secondPointer]) {
				result.add(nums1[firstPointer]);
				firstPointer++;
				secondPointer++;
			} else if(nums1[firstPointer] > nums2[secondPointer]) {
				secondPointer++;
			} else {
				firstPointer++;
			}
		}
		int[] arrayResult = new int[result.size()];
		for(int i = 0 ; i<arrayResult.length ; i++) {
			arrayResult[i] = result.get(i);
		}
		return arrayResult;
    }
}
