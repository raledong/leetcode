package tree;

/**
 * @author rale
 *
 */
public class ConvertSortedListtoBinarySearchTree_109 {
	
	//双指针
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return sortedListToBST(head, null);
    }
	
	public TreeNode sortedListToBST(ListNode head, ListNode tail){
		if(head==tail) return null;
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=tail && fast.next!=tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode cHead = new TreeNode(slow.val);
		cHead.left = sortedListToBST(head, slow);
		cHead.right = sortedListToBST(slow.next, tail);
		return cHead;
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
