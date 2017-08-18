package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rale
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths_257 {
	
	
	//递归
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root!=null) binaryTreePaths(root, "", result);
		return result;
    }
	
	public void binaryTreePaths(TreeNode root, List<Integer> current, List<String> result){
		current.add(root.val);
		if(root.left==null && root.right==null){
			StringBuilder s = new StringBuilder();
			for(Integer i : current){ s.append(i);s.append("->");}
			s.delete(s.length()-2, s.length());
			result.add(s.toString());
		}
		if(root.left!=null){
			binaryTreePaths(root.left, current, result);
		}
		if(root.right!=null){
			binaryTreePaths(root.right, current, result);
		}
		current.remove(current.size()-1);
	}
	
	public void binaryTreePaths(TreeNode root, String current, List<String> result){
		if(root.left==null && root.right==null){
			current += root.val;
			result.add(current);
		}
		if(root.left!=null){
			binaryTreePaths(root.left, current+root.val+"->", result);
		}
		if(root.right!=null) binaryTreePaths(root.right, current+root.val+"->", result);
	}
	
	
}
