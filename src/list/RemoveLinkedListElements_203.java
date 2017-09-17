package list;

/**
 * @author rale
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements_203 {
	
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while(tmp.next!=null){
        	if(tmp.next.val==val) tmp.next = tmp.next.next;
        	else tmp = tmp.next;
        }
        return dummy.next;
    }
}
