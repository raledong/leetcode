package tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rale
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserizalizeBST_449 {
	//利用先序和中序表达式来序列化和反序列化
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder result) {
    	if(root != null) {
    		result.append(root.val);
    		result.append(":");
    		preorder(root.left, result);
    		preorder(root.right, result);
    	}
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data==null || data.isEmpty()) return null;
        String[] preorder = data.split(":");
        String[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				Integer i1 = Integer.valueOf(o1);
				Integer i2 = Integer.valueOf(o2);
				return i1.compareTo(i2);
			}
        	
        });
        
        return build(inorder, preorder, 0, 0, inorder.length);
    }
    
    public TreeNode build(String[] inorder, String[] preorder, int inorderStart, int preorderStart, int length) {
    	if(length <= 0) return null;
    	TreeNode root = new TreeNode(Integer.valueOf(preorder[preorderStart]));
    	for(int i = inorderStart ; i < inorderStart+length ; i++) {
    		if(inorder[i].equals(preorder[preorderStart])) {
    			root.left = build(inorder, preorder, inorderStart, preorderStart+1, i-inorderStart);
    			root.right = build(inorder, preorder, i+1, preorderStart+i-inorderStart+1, inorderStart+length-i-1);
    			break;
    		}
    	}
    	
    	return root;
    }
    //反而不如直接排序快
    public TreeNode deserialize2(String data) {
    	if(data==null || data.isEmpty()) return null;
        String[] preorder = data.split(":");
        int[] preorderInt = Arrays.stream(preorder).mapToInt(Integer::valueOf).toArray();
        return build(preorderInt, 0, preorder.length);
    }
    
    public TreeNode build(int[] preorder, int start, int end) {
    	if(start>=end) return null;
    	TreeNode t = new TreeNode(preorder[start]);
    	int index = start+1;
    	while(index<end && preorder[index] < preorder[start]) {index++;}
    	t.left = build(preorder, start+1, index);
    	t.right = build(preorder, index, end);
    	return t;
    }
    
    // Decodes your encoded data to tree.
    // pre-order traversal
    public TreeNode deserialize3(String data) {
        if (data==null) return null;
        String[] strs = data.split(":");
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    
    private TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        root.left = getNode(samllerQueue);
        root.right = getNode(q);
        return root;
    }
    public static void main(String[] args) {
    	SerializeAndDeserizalizeBST_449 s = new SerializeAndDeserizalizeBST_449();
    	TreeNode t1 = new TreeNode(2);
    	TreeNode t2 = new TreeNode(1);
    	TreeNode t3 = new TreeNode(3);
    	t1.left = t2;
    	t1.right = t3;
    	String result = s.serialize(t1);
    	System.out.println(result);
    	TreeNode d = s.deserialize2(result);
    }
}
