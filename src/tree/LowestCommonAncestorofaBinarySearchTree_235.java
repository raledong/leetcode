package tree;

/**
 * @author rale
 * iven a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorofaBinarySearchTree_235 {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(p.val > q.val){
			 return lca(root, q, p);
		 }else{
			 return lca(root, p, q);
		 }
	 }
	 
	 public TreeNode lca(TreeNode root, TreeNode small, TreeNode large){
		 if(root.val < small.val){
			 return lca(root.right, small, large);
		 }else if(root.val > large.val){
			 return lca(root.left, small, large);
		 }
		 return root;
	 }
}
