package list;

/**
 * @author rale
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup_25 {
	//递归
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // 
            curr = reverseKGroup(curr, k); 
            while (count-- > 0) { 
                ListNode tmp = head.next; 
                head.next = curr; 
                curr = head; 
                head = tmp; 
            }
            head = curr;
        }
        return head;
    }

	public class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
}
