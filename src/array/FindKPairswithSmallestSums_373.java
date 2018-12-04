package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums_373 {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
		if(nums1.length == 0 || nums2.length == 0 || k == 0) return result;
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] + o1[1] - o2[0] - o2[1];
			}});
		
		for(int i = 0 ; i<nums1.length ; i++){
			heap.offer(new int[]{nums1[i], nums2[0], 0});
		}
		while(k-- != 0 && !heap.isEmpty()) {
			int[] min = heap.poll();
			result.add(new int[]{min[0], min[1]});
			if(min[2] == nums2.length) continue;
			heap.offer(new int[]{min[0], nums2[min[2]+1], min[2] + 1});
		}
		return result;
		
    }
	
	public static void main(String[] args) {
		FindKPairswithSmallestSums_373 f = new FindKPairswithSmallestSums_373();
		f.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
	}
}
