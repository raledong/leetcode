package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreesII_95 {
	public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
	public List<TreeNode> generateTrees(int start, int end){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start>end){
			result.add(null);
		}else if(start==end){
			result.add(new TreeNode(start));
		}else{
			for(int i = start ; i<=end ; i++){
				List<TreeNode> left = generateTrees(start, i-1);
				List<TreeNode> right = generateTrees(i+1, end);
				for(TreeNode tempLeft : left){
					for(TreeNode tempRight : right){
						TreeNode root = new TreeNode(i);
						root.left = tempLeft;
						root.right = tempRight;
						result.add(root);
					}
				}
			}
			
		}
		return result;
		
	}
	
	
}
