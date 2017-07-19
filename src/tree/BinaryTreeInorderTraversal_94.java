package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversal(root, result);
        return result;
    }
	
	public void inorderTraversal(TreeNode root, List<Integer> result){
		if(root==null) return;
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);
	}
	
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		do{
			while(root!=null){
				stack.push(root);
				root = root.left; 
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}while(!(stack.isEmpty() && root==null));
		return result;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
