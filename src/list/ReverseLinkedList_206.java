package list;

/**
 * @author rale
 * Reverse a singly linked list.
 */
public class ReverseLinkedList_206 {
	/**
	 * 非递归实现
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode sec = head.next;
        while(first.next!=null){
        	first.next = sec.next;
        	sec.next = dummy.next;
        	dummy.next = sec;
        	sec = first.next;
        }
        return dummy.next;
        
    }
	
	/**
	 * 递归实现
	 */
	ListNode tail = new ListNode(0);
	public ListNode reverseList2(ListNode head){
		if(head==null) return null;
		if(head.next == null){
			tail = head;
			return head;
		}
		ListNode next = reverseList(head.next);
		tail.next =head;
		head.next = null;
		tail = tail.next;
		return next;
	}
}
