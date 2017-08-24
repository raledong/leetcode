package list;

/**
 * @author rale
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII_142 {

	public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode runner = head, walker = head;
        while(runner.next!=null && runner.next.next!=null){
        	walker = walker.next;
        	runner = runner.next.next;
        	if(walker==runner){
        		ListNode temp = head;
        		while(temp!=walker){
        			temp = temp.next;
        			walker = walker.next;
        		}
        		return temp;
        	}
        }
        
        return null;
    }
}
