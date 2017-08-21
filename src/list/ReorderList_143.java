package list;

import java.util.LinkedList;

/**
 * @author rale
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * 
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList_143 {
	
	//O(2n) 利用链表实现的双向队列来实现
	public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next == null)return;
        LinkedList<ListNode> queue = new LinkedList<ListNode>();
        ListNode temp = head;
        while(temp.next!=null){
        	queue.add(temp.next);
        	temp = temp.next;
        }
        temp = head;
        boolean removeLast = true;
        while(!queue.isEmpty()){
            if(removeLast){
                temp.next = queue.removeLast();
        	    temp = temp.next;
                removeLast = false;
            }else{
                temp.next = queue.removeFirst();
                temp = temp.next; 
                removeLast = true;
            }
        }
        temp.next = null;  
    }
	
	//诶呀 这个方法没想到真的有点愚了
	//1-2-3-4-5-6
	//1-2-3-6-5-4
	//1-6-2-5-3-4
	public void reorderList2(ListNode head){
		if(head==null || head.next==null || head.next.next==null) return;
		ListNode fast = head, slow = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode middleNode = slow;
		ListNode preMiddleNode = slow.next;
		while(preMiddleNode.next!=null){
			ListNode current = preMiddleNode.next;
			preMiddleNode.next = current.next;
			current.next = middleNode.next;
			middleNode.next = current;
		}
		
		ListNode tempHead = head;
		ListNode reversedNode = middleNode.next;
		while(tempHead != middleNode){
			middleNode.next = reversedNode.next;
			reversedNode.next = tempHead.next;
			tempHead.next = reversedNode;
			tempHead = reversedNode.next;
			reversedNode = middleNode.next;	
		}
		
	}
}
