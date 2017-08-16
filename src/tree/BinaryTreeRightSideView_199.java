package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rale
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView_199 {
	//bfs
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root!=null){
        	q.add(root);
        	while(!q.isEmpty()){
        		int size = q.size();
        		int right = 0;
        		for(int i = 0 ; i<size ; i++){
        			TreeNode temp = q.poll();
        			right = temp.val;
        			if(temp.left!=null) q.offer(temp.left);
        			if(temp.right!=null) q.offer(temp.right);
        		}
        		result.add(right);
        	}
        }
        return result;
    }
	
	//递归 优先遍历右子节点 一旦存在右子节点，就把他加到结果集中 dfs
	public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travelRight(res, root, 0);
        return res;
    }
    
    private static void travelRight(List<Integer> res, TreeNode node, int level) {
        if (node == null) return;
        
        if (res.size() == level) {
            res.add(node.val);
        }
        
        travelRight(res, node.right, level+1);
        travelRight(res, node.left, level+1);
    }
}
