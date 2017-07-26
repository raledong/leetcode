package tree;

/**
 * @author rale
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	
	//递归
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = buildTree(preorder, 0, inorder, 0, preorder.length);
        return result;
    }
	
	public TreeNode buildTree(int[] preorder, int pStart, int[] inorder, int iStart, int length){
		if(length<=0) return null;
		TreeNode node = new TreeNode(preorder[iStart]);
		int pIndex = pStart;
		while(pIndex<pStart+length && inorder[pIndex++]!=preorder[iStart]);
		int leftLength = pIndex-pStart-1;
		node.left = buildTree(preorder, pStart, inorder,iStart+1,leftLength);
		node.right = buildTree(preorder, pIndex, inorder, iStart+leftLength+1, length-leftLength-1);
		return node;
	}
}
