package tree;

/**
 * @author rale
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers_129 {
	int total = 0;
	public int sumNumbers(TreeNode root) {
         if(root!=null) sumNumbers(root, 0);
         return total;
    }
	
	public void sumNumbers(TreeNode root, int current){
		if(root.left==null&&root.right==null) {
			total+=current*10+root.val;
			return;
		}
		if(root.left!=null) sumNumbers(root.left, current*10+root.val);
		if(root.right!=null) sumNumbers(root.right, current*10+root.val);
	}
}
