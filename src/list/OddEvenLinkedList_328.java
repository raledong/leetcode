package list;

/**
 * @author rale
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList_328 {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode cur = head,
        		odd = dummyOdd,
        		even = dummyEven;
        int count = 0;
        while(cur!=null){
        	if(count%2==0){
        		odd.next = cur;
        		odd = odd.next;
        		cur = cur.next;
        	}else{
        		even.next = cur;
        		even = even.next;
        		cur = cur.next;
        	}
        	count++;
        }
        odd.next = dummyEven.next;
        even.next = null;
        return dummyOdd.next;
    }
	
	public ListNode oddEvenList2(ListNode head) {
        if(head==null) return head;
        ListNode odd,even,evenStart;
        odd=head;
        even=head.next;
        evenStart=even;
        
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next; 
        }
        odd.next=evenStart;
        return head;
    }
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		OddEvenLinkedList_328 o = new OddEvenLinkedList_328();
		o.oddEvenList(l1);
	}
}
