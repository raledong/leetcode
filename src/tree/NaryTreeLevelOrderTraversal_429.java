package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class NaryTreeLevelOrderTraversal_429 {
	
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root != null) {
	        LinkedList<Node> queue = new LinkedList<Node>();
	        queue.offer(root);
	        //下一行的元素数量
	        int next = 1;
	        List<Integer> levelOrderPerHeight = new ArrayList<Integer>();
	        while(!queue.isEmpty()) {
	        	next--;
	        	Node tmp = queue.poll();
	        	levelOrderPerHeight.add(tmp.val);
	        	if(tmp.children != null && !tmp.children.isEmpty()) {
	        		for(Node child : tmp.children) {
	        			queue.offer(child);
	        		}
	        	}
	        	if(next == 0) {
	        		result.add(levelOrderPerHeight);
	        		levelOrderPerHeight = new ArrayList<Integer>();
	        		next = queue.size();
	        	}
	        }
		}
		return result;
    }
	
	public List<List<Integer>> levelOrder2(Node root) { 
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		levelOrder(root, result, 0);
		return result;
	}
	
	public void levelOrder(Node root, List<List<Integer>> result, int level) {
		if(root == null) return;
		if(level == result.size()) {
			result.add(new ArrayList<>());
		}
		List<Integer> tmp = result.get(level);
		tmp.add(root.val);
		for(Node child : root.children) {
			levelOrder(child, result, level+1);
		}
	}
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
}
