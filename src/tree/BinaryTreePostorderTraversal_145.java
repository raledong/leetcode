package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].


 */
public class BinaryTreePostorderTraversal_145 {
	
	//recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		postorderTraversal(root, result);
		return result;
    }
	
	public void postorderTraversal(TreeNode root, List<Integer> result){
		if(root != null){
			postorderTraversal(root.left, result);
			postorderTraversal(root.right, result);
			result.add(root.val);
		}
	}
	
	//iterative
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root!=null){
			stack.push(root);
			TreeNode prev = root;
			while(!stack.isEmpty()){
				root = stack.peek();
				if(root.left!=prev){
					while(root.left!=null){
						stack.push(root.left);
						root = root.left;
					}
				}

				root = stack.peek();
				if(root.right==null){
					prev = stack.pop();
					result.add(prev.val);
					while((root=stack.peek())!=null && root.right==prev){
						prev = stack.pop();
						result.add(prev.val);
					}
				}else{
					stack.push(root.right);
					prev = root;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		BinaryTreePostorderTraversal_145 b = new BinaryTreePostorderTraversal_145();
		TreeNode t = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t.left = t2;
		b.postorderTraversal2(t);
	}
}
