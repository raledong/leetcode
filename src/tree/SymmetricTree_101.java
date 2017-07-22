package tree;

import java.util.LinkedList;

/**
 * @author rale
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree_101 {
	public boolean isSymmetric(TreeNode treeNode){
		if(treeNode==null) return true;
		return isSymmetric(treeNode.left, treeNode.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right){
		if(left==null && right==null) return true;
		if(left!=null && right!=null && left.val==right.val){
			return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
		}
		return false;
	}
	
	public boolean isSymmetric2(TreeNode treeNode){
		if(treeNode==null) return true;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode left = treeNode.left, right = treeNode.right;
		stack.push(left);
		stack.push(right);
		while(!stack.isEmpty()){
			right = stack.pop();
			left = stack.pop();
			if(right==null && left==null)continue;
			else if(left==null || right==null)return false;
			else if(left.val==right.val){
				stack.push(left.left);
				stack.push(right.right);
				stack.push(left.right);
				stack.push(right.left);
			}else{
				return false;
			}
		}
		return true;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
