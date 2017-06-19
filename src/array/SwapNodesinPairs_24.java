package array;

/**
 * @author rale
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs_24 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	 public ListNode swapPairs(ListNode head) {
		 ListNode start = new ListNode(0);
		 start.next = head;
		 ListNode pre = start;
		 while(head!=null && head.next!=null){
			 pre.next = head.next;
			 head.next = pre.next.next;
			 pre.next.next = head;
			 pre = pre.next.next;
			 head = pre.next;
		 }
		 return start.next;
	 }
	 
	 public static void main(String[] args){
		 SwapNodesinPairs_24 s = new SwapNodesinPairs_24();
		 ListNode l1 = s.new ListNode(1);
		 ListNode l2 = s.new ListNode(2);
		 l1.next = l2;
		 l2.next = null;
		 System.out.println(s.swapPairs(l1).val);
	 }
}
