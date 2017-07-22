package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rale
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal_102 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrder(root, 0, result);
        return result;
    }
	
	public void levelOrder(TreeNode treeNode, int height, List<List<Integer>> result){
		if(treeNode == null) return;
		if(height>result.size()-1){
			result.add(new ArrayList<Integer>());
		}
		result.get(height).add(treeNode.val);
		levelOrder(treeNode.left, height+1, result);
		levelOrder(treeNode.right, height+1, result);
	}
	
	public List<List<Integer>> levelOrder2(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null)return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int levNum = queue.size();
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0 ; i<levNum ; i++){
				if(queue.peek().left!=null)queue.offer(queue.peek().left);
				if(queue.peek().right!=null)queue.offer(queue.peek().right);
				temp.add(queue.poll().val);
			}
			result.add(temp);
		}
		return result;
	}
}
