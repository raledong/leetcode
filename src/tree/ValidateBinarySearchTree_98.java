package tree;

import java.util.LinkedList;

/**
 * @author rale
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree_98 {
	
	//中序遍历保证正确顺序
	public boolean isValidBST(TreeNode root) {
		long currentVal = Long.MIN_VALUE;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(root!=null || !stack.isEmpty()){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.val<=currentVal) return false;
			currentVal = root.val;
			root = root.right;
		}
		return true;
    }
	
	public boolean isValidBST2(TreeNode root){
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean isValid(TreeNode treeNode, long lowerBound, long upperBound){
		if(treeNode==null) return true;
		if(treeNode.val>=upperBound || treeNode.val<=lowerBound) return false;
		return isValid(treeNode.left, lowerBound,treeNode.val) && isValid(treeNode.right, treeNode.val, upperBound);
	}
	
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
