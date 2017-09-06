package tree;

import java.util.LinkedList;

/**
 * @author rale
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator_173 {
	TreeNode dummy = new TreeNode(0);
	public BinarySearchTreeIterator_173(TreeNode root) {
        LinkedList<TreeNode> t = new LinkedList<TreeNode>();
        if(root!=null){
            TreeNode prev = dummy;
            do{
            	while(root!=null){
            		t.push(root);
            		root = root.left;
            	}
            	root = t.pop();
            	System.out.println(root.val);
            	prev.right = root;
            	prev = prev.right;
            	root = root.right;
            }while(!(t.isEmpty() && root==null));
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return dummy.right==null;
    }

    /** @return the next smallest number */
    public int next() {
        dummy = dummy.right;
        return dummy.val;
    }
    
    
   
    
    public static void main(String[] args){
//    	TreeNode root = generateTree(
//    			new Integer[]{41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23},
////    			new Integer[]{41,37,44,24,39},
//    			0
//    			);
//    	LinkedList<TreeNode> t = new LinkedList<TreeNode>();
////    	do{
////        	while(root!=null){
////        		t.push(root);
////        		root = root.left;
////        	}
////        	root = t.pop();
////        	System.out.println(root.val);
////        	root = root.right;
////        }while(!(t.isEmpty() && root==null));
//    	BinarySearchTreeIterator_173 b = new BinarySearchTreeIterator_173(root);
    }
}
