package tree;

/**
 * @author rale
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree_110 {
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		BalancedTreeNode b = height(root);
		return b.isBalanced;
    }
	
	public BalancedTreeNode height(TreeNode root){
		if(root==null) {
			BalancedTreeNode b = new BalancedTreeNode(0);
			b.height = 0;
			b.isBalanced = true;
			return b;
		}
		BalancedTreeNode b = new BalancedTreeNode(root.val);
		b.left = height(root.left);
		b.right = height(root.right);
		b.height = Math.max(b.left.height, b.right.height)+1;
		b.isBalanced = b.left.isBalanced && b.right.isBalanced && Math.abs(b.left.height-b.right.height)<=1;
		return b;
	}
	
	//优化一下数据结构
	public boolean isBalanced2(TreeNode root) {
		if(root==null) return true;
		BalancedTreeNode2 b = height2(root);
		return b.isBalanced;
    }
	public class BalancedTreeNode{
		BalancedTreeNode left;
		BalancedTreeNode right;
		int height;
		boolean isBalanced;
		public BalancedTreeNode(int height){this.height = height;}
		
	}
	
	public BalancedTreeNode2 height2(TreeNode root){
		if(root==null) {
			BalancedTreeNode2 b = new BalancedTreeNode2();
			b.height = 0;
			b.isBalanced = true;
			return b;
		}
		BalancedTreeNode2 b = new BalancedTreeNode2();
		BalancedTreeNode2 left = height2(root.left);
		BalancedTreeNode2 right = height2(root.right);
		b.height = Math.max(left.height,right.height)+1;
		b.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)<=1;
		return b;
	}
	public class BalancedTreeNode2{
		int height;
		boolean isBalanced;
		
	}
	
	//用-1代表非BLT
	public boolean isBalanced3(TreeNode root) {
		if(root==null) return true;
		
		return isB(root)!=-1;
    }
	
	public int isB(TreeNode root){
		if(root==null)return 0;
		int heightLeft = isB(root.left);
		int heightRight = isB(root.right);
		if(heightLeft!=-1 && heightRight!=-1 && Math.abs(heightLeft-heightRight)<=1){
			return Math.max(heightLeft, heightRight)+1;
		}
		return -1;
	}
	
}
