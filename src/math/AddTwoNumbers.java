package math;
/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * **/
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode c1 = l1;
		ListNode c2 = l2;
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int sum = 0;
		while(c1!=null || c2!=null){
			sum /= 10;
			if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
		}
		if(sum/10 == 1){
			temp.next = new ListNode(1);
		}
		return result.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x;}
		void print(){
			ListNode temp = this;
			do{
				System.out.println(temp.val);
				temp = temp.next;
			}while(temp!=null);
		}
	}
	
	public static void main(String[] args){
		AddTwoNumbers add = new AddTwoNumbers();
//		ListNode l1 = add.new ListNode(2);
//		l1.next = add.new ListNode(4);
//		l1.next.next = add.new ListNode(3);
//		ListNode l2 = add.new ListNode(5);
//		l2.next = add.new ListNode(6);
//		l2.next.next = add.new ListNode(4);
		ListNode l1 = add.new ListNode(1);
		l1.next = add.new ListNode(8);
		ListNode l2 = add.new ListNode(0);
		add.addTwoNumbers(l1, l2).print();
	}
}
