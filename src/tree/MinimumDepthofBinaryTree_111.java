package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rale
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree_111 {
	
	//bfs
	public int minDepth(TreeNode root) {
		int minHeight = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root!=null){
			queue.add(root);
			L1:while(!queue.isEmpty()){
				int size = queue.size();
				for(int i = 0 ; i<size ; i++){
					TreeNode temp = queue.poll();
					if(temp.left==null && temp.right==null){
						minHeight++;
						break L1;
					}
					if(temp.left!=null) queue.add(temp.left);
					if(temp.right!=null) queue.add(temp.right);
				}
				minHeight++;	
			}
		}
        return minHeight;
    }
	
	//dfs
	public int minDepth2(TreeNode root){
		if(root==null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left==0 || right==0)? left+right+1 : Math.min(left, right) + 1;
	}
	
	
}
