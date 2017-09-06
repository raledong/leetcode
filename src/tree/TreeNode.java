package tree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
	/**
	 * 根据整数数组来递归生成一棵树
	 * @param list
	 * @param i
	 * @return
	 */
	 public static TreeNode generateTree(Integer[] list, int i){
	    	if(i>=list.length) return null;
	    	if(list[i]==null) return null;
	    	TreeNode root = new TreeNode(list[i]);
	    	root.left = generateTree(list, i*2+1);
	    	root.right = generateTree(list, i*2+2);
	    	return root;
	 }
}
