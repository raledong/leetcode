package tree;

import java.util.HashMap;

/**
 * @author rale
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode result = buildTree(inorder, 0, postorder, 0, inorder.length);
        return result;
    }
	
	public TreeNode buildTree(int[] inorder, int iStart, int[] postorder, int pStart, int length){
		if(length==0) return null;
		int midVal = postorder[pStart+length-1];
		TreeNode t = new TreeNode(midVal);
		int inIndex = iStart;
		while(inIndex<iStart+length && inorder[inIndex++]!=midVal);
		int leftLength = inIndex-iStart-1;
		t.left = buildTree(inorder,iStart,postorder,pStart,leftLength);
		t.right = buildTree(inorder,iStart+leftLength+1, postorder, pStart+leftLength, length-leftLength-1);
		return t;
	}
	
	
	//简单优化，利用hashmap数据结构来存储中序表达式数值所在的下标，减少低效的重复遍历
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i=0;i<inorder.length;++i)
			hm.put(inorder[i], i);
		return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
	                          postorder.length-1,hm);
	}

	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm){
		if (ps>pe || is>ie) return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
		TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
}
