package array;

/**
 * @author rale
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head==null){
			 return head;
		 }
		 ListNode result = new ListNode(-1);
		 result.next = head;
		 while(head.next!=null){
			 if(head.next.val==head.val){
				 head.next = head.next.next;
			 }else{
				 head = head.next;
			 }
			 
		 }
		 return result.next;
	 }
	 
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
}
