package list;

/**
 * @author rale
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *  */
public class PalindromeLinkedList_234 {
	
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) return true;
        ListNode prevSlow=null, prevFast=null, fast = head, slow = head;
        while(fast!=null && fast.next!=null){
        	prevSlow = slow;
        	slow = slow.next;
        	prevFast = fast.next;
        	fast = prevFast.next;
        }
        prevSlow.next = null;
        if(fast!=null) prevFast = fast;
        
        ListNode cur = prevFast;
        while(slow!=prevFast){
        	ListNode next = cur.next; 
        	cur.next = slow;
        	slow = slow.next;
        	cur.next.next = next;
        }
        
        do{
        	if(prevFast.val != head.val) return false;
        	prevFast = prevFast.next;
        	head = head.next;
        }while(prevFast!=null && head!=null);
        return true;
    }
}
