package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListwithRandomPointer_138 {
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head;
        while(temp!=null){
        	map.put(temp, new RandomListNode(temp.label));
        	temp = temp.next;
        }
        
        temp = head;
        while(temp!=null){
        	RandomListNode cur = map.get(temp);
        	cur.next = map.get(temp.next);
        	cur.random = map.get(temp.random);
        	temp = temp.next;
        }
        return map.get(head);
    }
	
	//将新加的节点作为一个备份加入原来的链表中
	public RandomListNode copyRandomList2(RandomListNode head) {
		if(head==null) return null;
        RandomListNode current = head, copyHead = null, copyCurrent = null;
        
        while(current!=null){
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            current.next = temp;
            current = current.next.next;
        }
        
        current = head;
        while(current!=null){
            if(current.random!=null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        current = head;
        copyCurrent = copyHead = head.next;
        head.next = head.next.next;
        while(current != null){
            current.next = current.next.next;
            copyCurrent.next = copyCurrent.next.next;
            copyCurrent = copyCurrent.next;
            current = current.next;
        }
        return copyHead;
    }
}
