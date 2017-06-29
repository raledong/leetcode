package array;

/**
 * @author rale
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII_82 {

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prevNode = start;
        ListNode current = head;
        while(current != null){
        	if(current.next != null && current.val == current.next.val){
        		do{
        			current = current.next;
        		}while(current.next != null && current.val == current.next.val);
        		prevNode.next = current.next;
        	}else{
        		prevNode = current;
        	}
        	current = current.next;
        }
        return start.next;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x;}
	}
	
	public static void main(String[] args){
		RemoveDuplicatesfromSortedListII_82 r = new RemoveDuplicatesfromSortedListII_82();
		r.deleteDuplicates(toListNode(new int[]{1,1,2,2}));
				
	}
	
	public static ListNode toListNode(int[] values){
		ListNode root = new RemoveDuplicatesfromSortedListII_82().new ListNode(0);
		ListNode current = root;
		for(int i = 0 ; i<values.length ; i++){
			ListNode l = new RemoveDuplicatesfromSortedListII_82().new ListNode(values[i]);
			current.next = l;
			current = l;
		}
		return root.next;
	}
}
