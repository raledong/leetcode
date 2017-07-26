package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
	//非递归
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root!=null){
        	int height = 0;
        	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        	stack.add(root);
        	while(!stack.isEmpty()){
        		List<Integer> temp = new LinkedList<Integer>();
        		int size = stack.size();
        		if(height%2==0){
        			for(int i = 0 ; i<size ; i++){
        				TreeNode tempNode = stack.pop();
        				temp.add(tempNode.val);
        				if(tempNode.left!=null) stack.add(tempNode.left);
        				if(tempNode.right!=null) stack.add(tempNode.right);
        			}
        		}else{
        			for(int i = 0 ; i<size ; i++){
        				TreeNode tempNode = stack.pop();
        				temp.add(0, tempNode.val);
        				if(tempNode.left!=null) stack.add(tempNode.left);
        				if(tempNode.right!=null) stack.add(tempNode.right);
        			}
        		}
        		result.add(temp);
        		height++;
        	}
        }
        return result;
    }
	
	//递归
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(root, 0, result);
		return result;
	}
	
	public void dfs(TreeNode node, int height, List<List<Integer>> result){
		if(node==null) return;
		if(height==result.size()) result.add(new LinkedList<Integer>());
		if(height%2==0){
			result.get(height).add(node.val);
		}else{
			result.get(height).add(0, node.val);
		}
		dfs(node.left, height+1, result);
		dfs(node.right, height+1, result);
	}
	
	
}
