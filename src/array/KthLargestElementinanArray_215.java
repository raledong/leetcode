package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author rale
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray_215 {
	
	//方法一：直接排序
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
	
	//方法二：窗口 窗口底层的数据结构用priorityQueue实现
	public int findKthLargest2(int[] nums, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int num : nums){
			queue.offer(num);
			if(queue.size() > k){
				queue.poll();
			}
		}
		return queue.peek();
	}
}
