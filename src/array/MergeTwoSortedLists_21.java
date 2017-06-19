package array;

/**
 * @author rale
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists_21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
		ListNode temp = new ListNode(0);
		start.next = temp;
        while(l1!=null && l2!=null){
        	if(l1.val <= l2.val){
        		temp.next = l1;
        		l1 = l1.next;
        	}else{
        		temp.next = l2;
        		l2 = l2.next;
        	}
        	temp = temp.next;
        }
        if(l1!=null){
        	temp.next = l1;
        }
        if(l2!=null){
        	temp.next = l2;
        }
        return start.next.next;
    }
	
	public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2){
		if(l1==null){
			return l2;
		}else if (l2==null){
			return l1;
		}
		ListNode mergeHead;
		if(l1.val <= l2.val){
			mergeHead = l1;
			mergeHead.next = mergeTwoLists_recursive(l1.next, l2);
		}else{
			mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		return mergeHead;
	}
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
