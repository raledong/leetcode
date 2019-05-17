package list;

import java.util.Stack;

/**
 * @author rale
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 
 */
public class AddTwoNumbersII_445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode result = new ListNode(0);
        int carry = 0;
        while(rl1 != null || rl2 != null || carry != 0) {
        	int add = (rl1 == null ? 0 : rl1.val)
        			+ (rl2 == null ? 0 : rl2.val)
        			+ carry;
        	carry = add / 10;
        	ListNode tmp = new ListNode(add % 10);
        	tmp.next = result.next;
        	result.next = tmp;
        	rl1 = rl1==null? rl1 : rl1.next;
        	rl2 = rl2==null? rl2 : rl2.next;
        }
        return result.next;
    }
	
	public ListNode reverse(ListNode l) {
		ListNode dummy = new ListNode(0);
		dummy.next = l;
		ListNode cur = l;
		while(cur!= null && cur.next != null) {
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = dummy.next;
			dummy.next = next;
		}
		return dummy.next;
	}

	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
        	s2.push(l2.val);
        	l2 = l2.next;
        }
        
        int carry = 0;
        ListNode result = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
        	int add = (s1.isEmpty() ? 0 : s1.pop())
        			+ (s2.isEmpty() ? 0 : s2.pop())
        			+ carry;
        	carry = add / 10;
        	ListNode tmp = new ListNode(add % 10);
        	tmp.next = result.next;
        	result.next = tmp;
        }
        return result.next;
	}

}
