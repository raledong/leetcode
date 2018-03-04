package design;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author rale
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBinaryTree_297 {
	private static final String NULL = "N";
	private static final String SPLITOR = ",";
	
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder result = new StringBuilder();
    	inOrder(root, result);
    	return result.toString();
    }
    
    private void inOrder(TreeNode root, StringBuilder result){
    	if(root==null){
    		result.append(NULL).append(SPLITOR);
    	}else{
    		result.append(root.val).append(SPLITOR);
    		inOrder(root.left, result);
    		inOrder(root.right, result);
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	Deque<String> nodes = new LinkedList<String>(Arrays.asList(data.split(SPLITOR)));
    	return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
    
    
    public static void main(String[] args){
    	SerializeandDeserializeBinaryTree_297 s = new SerializeandDeserializeBinaryTree_297();
    	System.out.println(s.serialize(TreeNode.generateTree(new Integer[]{1,2,3,null,null,4,5}, 0)));
    }
    
}
