package other;

/**
 * @author rale
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example:

Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenaMultilevelDoublyLinkedList_430 {

	/**
	 * 返回head， 但是会出现大量重复的遍历，遍历的次数由子节点的深度决定
	 * @param head
	 * @return
	 */
	public Node flatten(Node head) {
        if(head == null) return head;
        Node tmp = head;
        while(tmp != null) {
        	if(tmp.child != null) {
        		Node child = flatten(tmp.child);
        		tmp.child = null;
        		Node next = tmp.next;
        		tmp.next = child;
        		child.prev = tmp;
        		while(child.next != null) {
        			child = child.next;
        		}
        		child.next = next;
        		if(next != null) {
            		next.prev = child;
        		}
        		tmp = next;
        	}else {
            	tmp = tmp.next;

        	}
        }
        return head;
    }
	
	/**
	 * 返回tail，极大的减少了重复遍历的次数，用O（N）的时间复杂度完成数据重构
	 * @param head
	 * @return
	 */
	public Node flatten2(Node head) {
		flattenAndReturnTail(head);
		return head;
	}
	
	public Node flattenAndReturnTail(Node head) {
		if(head == null) return null;
		if(head.child == null) {
			if(head.next == null) return head;
			return flattenAndReturnTail(head.next);
		}else {
			Node child = head.child;
			head.child = null;
			
			Node next = head.next;
			Node childTail = flatten(child);
			head.next  = child;
			child.prev = head;
			if(next != null) {
				childTail.next = next;
				next.prev = childTail;
				return flattenAndReturnTail(next);
			}
			return childTail;
		}
	}
	
	public Node flatten3(Node head) {
		if(head == null) return null;
		
		Node tmp = head;
		while(tmp != null) {
			if(tmp.child != null) {
				
				Node child = tmp.child;
				tmp.child = null;
				
				Node next = tmp.next;
				tmp.next = child;
				child.prev = tmp;
				while(child.next != null) {
					child =  child.next;
				}
				
				if(next != null) {
                    child.next = next;
                    next.prev = child;
                }
			}
			tmp = tmp.next;
		}
		return head;
	}
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	};
}
