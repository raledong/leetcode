package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author rale
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree_104 {
	
	//递归
	public int maxDepth(TreeNode root) {
        
		if(root == null){
			return 0;
		}
		return Math.max( maxDepth(root.left), maxDepth(root.right) ) + 1;
    }
	
	//使用中序遍历的方法，利用链表的数据结构
	public int maxDepth2(TreeNode root) {
        if (root == null)
		return 0;
	
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
	
        stack.push(root);
        int count = 0;
	
        while (!stack.isEmpty()) {
        	int size = stack.size();
        	while (size-- > 0) {
        		TreeNode cur = stack.pop();
        		if (cur.left != null)
        			stack.addLast(cur.left);
        		if (cur.right != null)
        			stack.addLast(cur.right);
        	}
        	count++;

        }
        return count;
	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	
}
