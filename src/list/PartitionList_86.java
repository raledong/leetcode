package list;

/**
 * @author rale
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example:
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList_86 {
	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null){
			return head;
		}
        ListNode start = new ListNode(0);
        ListNode prev = new ListNode(0);
        ListNode currentPrev = new ListNode(0);
        start.next = prev;
        prev.next = head;
        currentPrev.next = head;
        while(currentPrev.next!=null && currentPrev.next.val<x){
        	currentPrev = currentPrev.next;
        	prev = prev.next;
        }
        while(currentPrev!=null && currentPrev.next!=null){
        	int val = currentPrev.next.val;
        	if(val < x){
        		ListNode temp = currentPrev.next;
        		currentPrev.next = currentPrev.next.next;
        		temp.next = prev.next;
        		prev.next = temp;
        		prev = prev.next;	
        	}else{
            	currentPrev = currentPrev.next;
        	}
        }
        return start.next.next;
    }
	
	public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr = head, first = dummy1, second = dummy2;
        while (curr != null) {
            if (curr.val < x) {
                first.next = curr;
                first = first.next;
            } else {
                second.next = curr;
                second = second.next;
            }
            curr = curr.next;
        }
        first.next = dummy2.next;
        second.next = null;
        return dummy1.next;
    }
	
	public static void main(String[] args){
		PartitionList_86 p = new PartitionList_86();
		ListNode root = p.new ListNode(3);
		ListNode l2 = p.new ListNode(1);
		ListNode l3 = p.new ListNode(2);
		root.next = l2;
		l2.next = l3;
		p.partition(root, 3);
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
