package reservoirsampling;

import java.util.Random;

/**
 * @author rale
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the same probability of being chosen.
 * 
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? 
 * Could you solve this efficiently without using extra space?
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
public class LinkedListRandomNode_382 {

	private ListNode head;
	private Random r;
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode_382(ListNode head) {
		this.head = head;
		this.r = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode tmp = this.head;
		int result = 0;
		int index = 1;
		do{
			if(r.nextInt(index) == 0) {
				result = tmp.val;
			}
			tmp = tmp.next;
			index++;
		}while(tmp != null);
		return result;
	}
}
