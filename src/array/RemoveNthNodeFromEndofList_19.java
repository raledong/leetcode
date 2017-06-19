package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass
 */
public class RemoveNthNodeFromEndofList_19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> nodeList = new ArrayList<ListNode>();
		ListNode start = new ListNode(0);
		start.next = head;
		nodeList.add(start);
		
		while(head != null){
			nodeList.add(head);
			head = head.next;
		}
		int index = nodeList.size() - n;
		nodeList.get(index-1).next = nodeList.get(index).next;
		
		return nodeList.get(0).next;
    }

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode start = new ListNode(0);
        start.next = head;
	    ListNode slow = start;
		ListNode fast = start;
		
		for(int i = 0 ; i<n+1 ; i++){
			fast = fast.next;
		}
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return start.next;
    }
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args){
		
	}
}
