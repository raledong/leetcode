package twopointers;

/**
 * @author rale
 * You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.

 

Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 

Note:

-1000 ≤ nums[i] ≤ 1000
nums[i] ≠ 0
1 ≤ nums.length ≤ 5000
 */
public class CircularArrayLoop_457 {
	
	public boolean circularArrayLoop(int[] nums) {
		if(nums==null || nums.length<=1) return false;
		int n = nums.length;
		int count = 0;
		int prev = 0;
		nums[prev] += 2000;
		do {
			int next = getNext(nums, prev);
			if(nums[next] > 1000 
					&& next != prev 
					&& prev != getNext(nums, next) 
					&& (nums[next] - 2000) * (nums[prev]-2000) > 0) {
				return true;
			}
			count++;
			nums[next] += 2000;
			if(next == prev || prev == getNext(nums, next) ) {
				for(int i = 1 ; i<nums.length ; i++) {
					if(nums[(i + next) % n] <= 1000) {
						prev = (i + next) % n;
					}
				}
			}else {
				prev = next;
			}
		}while(count < nums.length);
		return false;
    }
	
	public int getNext(int[] nums, int i) {
		int n = nums.length;
		return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
	}
	
	public static void main(String[] args){
		CircularArrayLoop_457 c = new CircularArrayLoop_457();
		c.circularArrayLoop(new int[]{-2,1,-1,-2,-2});
	}
}
