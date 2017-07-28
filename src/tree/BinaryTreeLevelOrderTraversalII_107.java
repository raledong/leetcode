package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rale
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII_107 {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root!=null) levelOrderBottom(root, 0, result);
		return result;
    }
	
	public void levelOrderBottom(TreeNode root, int height, List<List<Integer>> result){
		int resultSize = result.size();;
		if(height==result.size()) result.add(0, new ArrayList<Integer>());
		result.get(resultSize-height-1).add(root.val);
		height++;
		if(root.left!=null) levelOrderBottom(root.left, height, result);
		if(root.right!=null) levelOrderBottom(root.right, height, result);
	}
	
	public List<List<Integer>> levelOrderBottom2(TreeNode root){
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root!=null){
			queue.offer(root);
			while(!queue.isEmpty()){
				List<Integer> tempList = new ArrayList<Integer>();
				int tempSize = queue.size();
				while(tempSize-->0){
					TreeNode t = queue.poll();
					tempList.add(t.val);
					if(t.left!=null)queue.add(t.left);
					if(t.right!=null)queue.add(t.right);
				}
				result.add(0, tempList);
			}
		}
		return result;
	}
}
