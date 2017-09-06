package tree;

/**
 * @author rale
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes_222 {
	
	//超时==
	public int countNodes(TreeNode root) {
		if(root==null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
    }
	
	//递归
	int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes2(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes2(root.right)
                                         : (1 << h-1) + countNodes2(root.left);
    }
    
    //循环
    int height2(TreeNode root){
    	if(root==null) return -1;
    	int height = 0;
    	while(root.left!=null) {height++; root=root.left;}
    	return height;
    }
    
    public int countNodes3(TreeNode root) {
    	int count = 0;
        int height = height2(root);
    	while(root!=null){
    		if(height2(root.right)==height-1){
    			count += 1<<height;
    			root = root.right;
    		}else{
    			count += 1<<height-1;
    			root = root.left;
    		}
            height--;
    	}
    	return count;
    }
}
