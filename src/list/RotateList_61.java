package list;

/**
 * @author rale
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList_61 {

	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val = x; }
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null){
			return null;
		}
        ListNode firstPointer = head;
        int length = 0;
        while(firstPointer!= null && k > 0){
        	k--;
        	firstPointer = firstPointer.next;
        	length++;
        }
        if(k == 0){
        	if(firstPointer == null){
        		return head;
        	}
        	ListNode secondPointer = head;
            while(firstPointer != null && firstPointer.next!=null){
            	secondPointer = secondPointer.next;
            	firstPointer = firstPointer.next;
            }
            System.out.println(firstPointer.val);
            firstPointer.next = head;
            ListNode result = secondPointer.next;
            secondPointer.next = null;
            return result;
        }else{
        	return rotateRight(head, k%length);
        } 
    }
	
	//效率比我高 唯一的区别在于先计算了节点的数量
	public ListNode rotateRight2(ListNode head, int k) {
        if(k==0 || head==null)
            return head;
        
        //get list lengh and last node
        ListNode last = head;
        int len = 1;
        while(last.next != null){
            last = last.next;
            len++;
        }
        
        
        k = k%len;
        if(k==0)
            return head;
        ListNode start = new ListNode(0);
        start.next = head;
        int count = len-k;
        while(count > 0){
            start = start.next;
            count--;
        }
        
        last.next = head;
        head = start.next;
        start.next = null;
        
        return head;
        
        
        
    }
	
	public static void main(String[] args){
		RotateList_61 r = new RotateList_61();
		ListNode n1 = r.new ListNode(10);
		ListNode n2 = r.new ListNode(20);
		ListNode n3 = r.new ListNode(30);
		ListNode n4 = r.new ListNode(40);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(r.rotateRight(n1, 2).val);
	}
}
