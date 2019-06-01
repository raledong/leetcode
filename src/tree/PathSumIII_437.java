package tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author rale
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIII_437 {
	
	public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()) {
        	tmp = queue.poll();
        	result += pathSumInorder(tmp, sum);
        	if(tmp.left != null) {
        		queue.offer(tmp.left);
        	}
        	if(tmp.right != null) {
        		queue.offer(tmp.right);
        	}
        }
        return result;
    }
	
	public int pathSumInorder(TreeNode root, int sum) {
		if(root == null) return 0;
		int result = 0;
        if(root.val == sum) {
        	result++;
        }
        result += pathSumInorder(root.left, sum-root.val);
        result += pathSumInorder(root.right, sum-root.val);
        return result;
	}
	
	
	public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preFixSum = new HashMap<>();
        preFixSum.put(0,1);
        return dfs(root, 0, sum, preFixSum);
    }
    
    private int dfs(TreeNode root, int sum, int target, HashMap<Integer, Integer> preFixSum) {
        if(root==null){
            return 0;
        }
        sum += root.val;
        int res = preFixSum.getOrDefault(sum-target, 0);
        
        preFixSum.put(sum, preFixSum.getOrDefault(sum, 0)+1);
        res+=dfs(root.left, sum, target, preFixSum) + dfs(root.right, sum, target, preFixSum);
        preFixSum.put(sum, preFixSum.getOrDefault(sum, 0)-1);
        
        return res;
    }
}
