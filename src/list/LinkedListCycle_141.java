package list;

/**
 * @author rale
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle_141 {
	
	public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head, runner = head;
        while(runner.next!=null && runner.next.next!=null){
        	walker = walker.next;
        	runner = runner.next.next;
        	if(walker==runner) return true;
        }
        return false;
    }
	
	public boolean hasCycle2(ListNode head){
		if(head==null) return false;
		ListNode dummy = new ListNode(0);
		while(head.next!=null){
			if(head.next==dummy)return true;
			ListNode temp = head.next;
			head.next = dummy;
			head = temp;
		}
		return false;
	}
}
