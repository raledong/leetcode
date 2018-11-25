package tree;
/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false
 * @author rale
 *
 */
public class VerifyPreorderSerializationofaBinaryTree_331 {
	public boolean isValidSerialization(String preorder) {
		if(preorder==null) return false;
		if(preorder.length() == 0) return true;
		String[] nodes = preorder.split(",");
		int nodeCount = 0;
		for(int i = nodes.length - 1; i >= 0 ; i--) {
			if(nodes[i].equals("#")) {
				nodeCount++;
			} else {
				nodeCount--;
			}
			if(nodeCount <= 0) return false;
		}
		return nodeCount == 1;
    }
}
