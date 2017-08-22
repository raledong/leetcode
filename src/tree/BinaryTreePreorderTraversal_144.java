package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal_144 {
	
	//recursive
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root,result);
        return result;
    }
	
	public void preorderTraversal(TreeNode root, List<Integer> result){
		if(root==null) return;
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
	}
	
	//iterative
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root!=null){
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode temp = stack.pop();
				result.add(temp.val);
				if(temp.right!=null) stack.push(temp.right);
				if(temp.left!=null) stack.push(temp.left);
			}
		}
		return result;
	} 
}
