package list;

/**
 * @author rale
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
 */
public class ReverseLinkedListII_92 {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0), start = new ListNode(0);
        dummy1.next = head;
        dummy2.next = head;
        start.next = dummy2;
        for(int i = 0 ; i <n-m+1 ; i++){
        	dummy1 = dummy1.next;
        }
        for(int i = 0; i<m-1 ; i++){
        	dummy1 = dummy1.next;
        	dummy2 = dummy2.next;
        }
        while(dummy2.next != dummy1){
        	ListNode temp = new ListNode(dummy2.next.val);
        	dummy2.next = dummy2.next.next;
        	temp.next = dummy1.next;
        	dummy1.next = temp;
        }
        return start.next.next;
    }
	
	//in one pass
	public ListNode reverseBetween2(ListNode head, int m, int n){
		if(m==n || head==null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		for(int i = 0 ; i<m-1 ; i++){
			prev = prev.next;
		}
		ListNode start = prev.next;
		ListNode then = start.next;
		for(int i = 0 ; i<n-m ; i++){
			start.next = then.next;
			then.next = prev.next;
			prev.next = then;
			then = start.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		ReverseLinkedListII_92 r = new ReverseLinkedListII_92();
		ListNode l1 = r.new ListNode(3);
		ListNode l2 = r.new ListNode(5);
		l1.next = l2;
		r.reverseBetween(l1, 1, 2);
	}
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){this.val = x;}
	}
}
