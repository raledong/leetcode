package tree;

/**
 * @author rale
 * Given a binary tree, flatten it to a linked list in-place.
For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.


 */
public class FlattenBinaryTreetoLinkedList_114 {
	
	//这是一种数据结构，具体参考一下某本书的某个解法
	public void flatten(TreeNode root) {
		if(root==null) return;
		TreeNode temp = root;
		TreeNode current = root;
		while(current!=null){
			if(current.left!=null){
				temp = current.left;
				while(temp.right!=null) temp = temp.right;
				temp.right = current.right;
				current.right = current.left;
				current.left = null;
				
			}
			current = current.right;
		}
    }
	
	//recursive 深度优先算法
	TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
