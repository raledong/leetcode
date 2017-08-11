package tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author rale
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree_99 {
	TreeNode t1;
	TreeNode t2;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
	
	//通过中序遍历进行判断
	public void inOrderTraversal(TreeNode root){
		if(root==null) return;
		inOrderTraversal(root.left);
		if(t1==null && prev.val>root.val){
			t1 = prev;
		}
		if(t1!=null && prev.val>root.val){
			t2 = root;
		}
		prev = root;
		inOrderTraversal(root.right);
	}
	
}
