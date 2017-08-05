package tree;

/**
 * @author rale
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode_116 {

	public void connect(TreeLinkNode root) {
		if(root==null) return;
		TreeLinkNode head = new TreeLinkNode(0);
		head = root;
		TreeLinkNode temp = root;
		TreeLinkNode current = root.left;
		while(current != null){
			if(temp==null){
				temp = head.left;
				current = temp.left;
				head = temp;
			}else if(current==temp.left){
				current.next = temp.right;
				temp = temp.next;
				current = current.next;
			}else{
				current.next = temp.left;
				current = current.next;
			}
		}
    }
	
	public static void main(String[] args){
		PopulatingNextRightPointersinEachNode_116 p = new PopulatingNextRightPointersinEachNode_116();
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		p.connect(t1);
		System.out.println(t4.next==t5);
	}
}
