package tree;

/**
 * @author rale
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST_230 {
	
	public int kthSmallest(TreeNode root, int k) {
		int num = numOfNode(root.left);
		if(num == k-1) return root.val;
		else if(num > k-1) return kthSmallest(root.left, k);
		else return kthSmallest(root.right, k-num-1);
    }
	
	public int numOfNode(TreeNode root){
		if(root==null) return 0;
		return numOfNode(root.left) + numOfNode(root.right) + 1;
	}

	//中序表达式
	private static int number = 0;
    private static int count = 0;

    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
	
}
