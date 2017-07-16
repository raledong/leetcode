package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		pathSum(root, sum, new ArrayList<Integer>(), result);
		return result;
    }
	
	public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
		if(root==null) return;
		sum -= root.val;
		if(isLeaf(root) && sum==0){
			path.add(root.val);
			result.add(new ArrayList<Integer>(path));
			path.remove(path.size()-1);
			return;
		}
		path.add(root.val);
		pathSum(root.left, sum, path, result);
		pathSum(root.right, sum, path, result);
		path.remove(path.size()-1);
		
		
	}
	
	private boolean isLeaf(TreeNode node){
		return node!=null && node.left==null && node.right==null;
	}
		

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
