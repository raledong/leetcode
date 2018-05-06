package other;

import tree.TreeNode;

/**
 * @author rale
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

 */
public class HouseRobberIII_337 {
	public int rob(TreeNode root) {
        if(root == null) return 0;
        int result1 = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int result2 = rob(root.left) + rob(root.right);
        return Math.max(result1, result2);
    }
	
	public int rob2(TreeNode root) {
        if (root == null) return 0;
        int[] value = robSum(root);
        return Math.max(value[0], value[1]);
    }
    
    private int[] robSum(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        
        int[] left = robSum(root.left);
        int[] right = robSum(root.right);
        
        //如果没有选中当前的节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //如果选中当前节点
        res[1] = root.val + left[0] + right[0];
        
        return res;
    }
}
