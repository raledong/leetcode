package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author rale
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * 
 * Example 1:
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * 
 * 
 * Example 2:
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * 
 * 
 * Example 3:
 * Input: [[1,2],[2,3]]Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class NonoverlappingIntervals_435 {
	
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
			}
        	
        });
        
        int count = 0;
        int end = intervals[0][1];
        for(int i = 1 ; i<intervals.length ; i++) {
        	int[] interval = intervals[i];
        	if(interval[0] < end) {;
        		count++;
                end = Math.min(end, interval[1]);
        	}else {
        		end = interval[1];
        	}
        }
        return count;
    }
	
	
}
