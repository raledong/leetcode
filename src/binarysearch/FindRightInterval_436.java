package binarysearch;

import java.util.Arrays;

/**
 * @author rale
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
 

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 

Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class FindRightInterval_436 {
	
	/**
	 * 二分法实现
	 * @param intervals
	 * @return
	 */
	public int[] findRightInterval(int[][] intervals) {		
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        
        Node[] leftIndex = new Node[intervals.length];
        for(int i = 0 ; i<intervals.length ; i++) {
        	Node n = new Node();
        	n.index = i;
        	n.value = intervals[i][0];
        	leftIndex[i] = n;
        }
        Arrays.sort(leftIndex);
        
        for(int i = 0 ; i<intervals.length ; i++) {
        	int rightIndex = intervals[i][1];
        	int left = 0, right = intervals.length-1;
        	while(left <=right) {
        		int mid = (left + right) / 2;
        		Node tmp = leftIndex[mid];
        		if(tmp.value > rightIndex) {
        			right = mid - 1;
        		}else {
        			left = mid + 1;
        		}
        	}
        	if(leftIndex[right].value == rightIndex) {
        		result[i] = leftIndex[right].index;
        	}else if(right<intervals.length-1) {
        		result[i] = leftIndex[right+1].index;
        	}
        	
        }
        return result;
    }
	
	public static class Node implements Comparable<Node>{
		int value;
		int index;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	public int[] findRightInterval2(int[][] intervals) {
		int[] result = new int[intervals.length];
		int min = intervals[0][0], max = intervals[0][1];
		
		for(int i = 1 ; i<intervals.length ; i++) {
			min = Math.min(min, intervals[i][0]);
			max = Math.max(max, intervals[i][1]);
		}
		
		int[] buckets = new int[max - min + 1];
		Arrays.fill(buckets, -1);
		for(int i = 0 ; i<intervals.length ; i++) {
			buckets[intervals[i][0] - min] = i;
		}
		
		for(int i = buckets.length-2 ; i>=0 ; i--) {
			if(buckets[i] == -1) buckets[i] = buckets[i+1]; 
		}
		
		for(int i = 0 ; i<intervals.length ; i++) {
			result[i] = buckets[intervals[i][1] - min];
		}
		return result;
	}
	
	public static void main(String[] args) {
		FindRightInterval_436 f = new FindRightInterval_436();
		f.findRightInterval(new int[][]{
			{4,5},{2,3},{1,2}
		});
	}
}
