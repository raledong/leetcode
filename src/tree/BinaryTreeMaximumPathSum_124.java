package tree;

/**
 * @author rale
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * 
 * For example:
 * Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum_124 {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxPathSumRec(root);
        return max;
    }
	
	public int maxPathSumRec(TreeNode root){
		if(root==null) return 0;
		int left = maxPathSumRec(root.left);
		int right = maxPathSumRec(root.right);
		max = Math.max(Math.max(max, Math.max(left+root.val, right+root.val)), left+root.val+right);
		return Math.max(Math.max(left+root.val, right+root.val), root.val);
	}
	
	public static void main(String[] args){
		BinaryTreeMaximumPathSum_124 b = new BinaryTreeMaximumPathSum_124();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		b.maxPathSum(t1);
	}
}
