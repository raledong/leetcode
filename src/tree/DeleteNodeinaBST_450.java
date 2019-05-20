package tree;

/**
 * @author rale
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 */
public class DeleteNodeinaBST_450 {
	
	
	public TreeNode deleteNode(TreeNode cur, int key) {
		if(cur == null) return null;
		else if(cur.val == key) {
			if(cur.left != null && cur.right != null) {
				TreeNode left = cur.left;
				while(left.right != null) {
					left = left.right;
				}
				cur.val = left.val;
				cur.left = deleteNode(cur.left, left.val);
			}else if(cur.left != null) {
				return cur.left;
			}else if(cur.right != null){
				return cur.right;
			}else {
				return null;
			}
		}else if(cur.val > key) {
			cur.left = deleteNode(cur.left, key);
		}else {
			cur.right = deleteNode(cur.right, key);
		}
		return cur;
	}
}
