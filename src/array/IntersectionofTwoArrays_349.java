package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rale
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionofTwoArrays_349 {

	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> nums3 = new ArrayList<Integer>();
            int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j])
            {
                if(!nums3.contains(nums1[i]))
                     nums3.add(nums1[i]);
                i++;
                j++;
             }
            else if(nums1[i]>nums2[j])
                j++;
            else
                i++;
        }
        int[] arr = new int[nums3.size()];
        for(int k=0;k<nums3.size();k++)
            arr[k]=nums3.get(k);
        return arr;
    }
}
