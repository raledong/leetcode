package other;

import java.util.LinkedList;

/**
 * @author rale
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */
public class SlidingWindowMaximum_239 {
	
	//使用链表存储有用的信息
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || k == 0) return new int[0];
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0 ; i<nums.length ; i++){
        	while(list.size() != 0 && list.getFirst() < i-k+1){
        		list.remove(0);
        	}
        	while(list.size()!=0 && nums[list.getLast()] < nums[i]){
        		list.remove(list.size()-1);
        	}
        	list.addLast(i);
        	if(i - k + 1 >= 0){
        		result[i-k+1] = nums[list.getFirst()];
        	}
        }
        return result;
    }
	
	public int[] maxSlidingWindow_noDataStructure(int[] nums, int k) {
		if(nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int max = 0;
        for(int i = 0 ; i<nums.length ; i++){
        	if(max < i - k + 1){
        		max = i;
        		for(int j = 1 ; j<k ; j++){
        			if(nums[i-j] > nums[max]){
        				max = i-j;
        			}
        		}
        	}
        	if(nums[i] > nums[max]) max = i;
        	if(i-k+1>=0){
        		result[i-k+1] = nums[max];
        	}
        }
        return result;
    }
	
	public static void main(String[] args){
		SlidingWindowMaximum_239 s = new SlidingWindowMaximum_239();
		s.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4);
	}
}
