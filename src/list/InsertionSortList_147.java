package list;

/**
 * @author rale
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList_147 {
	/**
	 * 新建的头指针指向原来的头节点
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curPrev = head; //当前节点的前一个节点
        ListNode cur = head.next;//当前进行判断的节点
        while(cur!=null){
        	//首先对最靠近的前置节点判断，如果前直接点比自己小，则不进行任何操作，并将指针指向下一个待操作值
        	if(curPrev.val<cur.val){
        		curPrev = curPrev.next;
        		cur = cur.next;
        		continue;
        	}
        	ListNode prev = dummy;
        	while(prev.next!=null && prev.next!=cur && prev.next.val<=cur.val){
        		prev = prev.next;
        	}
        	if(prev.next==cur){
        		curPrev = curPrev.next;
        		cur = cur.next;
        	}else{
        		curPrev.next = cur.next;
            	cur.next = prev.next;
            	prev.next = cur;
            	cur = curPrev.next;
        	}
        	
        }
        return dummy.next;
    }
	
	/**
	 * 重新创建一个指向原来链表的头指针，将源链表中的元素一次插入新链表中的适当位置
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList2(ListNode head) {
        if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
    }
	public static void main(String[] args){
		InsertionSortList_147 i = new InsertionSortList_147 ();
		ListNode head = new ListNode(2);
		ListNode b1 = new ListNode(1);
		head.next = b1;
		i.insertionSortList(head);
	}
	
	
}
