package list;

/**
 * @author rale
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList_148 {
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode prev = null, slow = head, fast = head;
		while(fast!=null && fast.next!=null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		return merge(l1, l2);
    }
	
	public ListNode merge(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				ListNode tmp = l1.next;
				cur.next = l1;
				l1.next = null;
				l1 = tmp;
			}else{
				ListNode tmp = l2.next;
				cur.next = l2;
				l2.next = null;
				l2 = tmp;
			}
			cur = cur.next;
		}
		if(l1==null) cur.next = l2;
		else cur.next = l1;
		return dummy.next;
	}
	
}
