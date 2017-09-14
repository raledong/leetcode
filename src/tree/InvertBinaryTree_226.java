package tree;

/**
 * @author rale
 * Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree_226 {
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null) return null;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        return root;
    }
}
