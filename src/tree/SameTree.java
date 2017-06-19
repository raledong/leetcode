package tree;

import java.util.Stack;

/**
 * @author rale
 * leetcode100
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * 提示 深度优先算法
 * 在本题的测试用例中，递归算法的效率更高，不知为何
 */
public class SameTree {

	//递归
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            return q==null?true:false;
        }else if(q==null){
            return p==null?true:false;
        }
        if(p.val == q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
	
	//循环 深度优先算法
	public boolean isSameTree2(TreeNode p, TreeNode q){
		Stack<TreeNode> stackP = new Stack<TreeNode>();
		Stack<TreeNode> stackQ = new Stack<TreeNode>();
		if(p!=null){
			stackP.push(p);
		}
		if(q!=null){
			stackQ.push(q);
		}
		while(!stackP.isEmpty() && !stackQ.isEmpty()){
			TreeNode tempP = stackP.pop();
			TreeNode tempQ = stackQ.pop();
			if(tempP.val!=tempQ.val){
				return false;
			}
			if(tempP.right!=null){
				stackP.push(tempP.right);
			}
			if(tempQ.right!=null){
				stackQ.push(tempQ.right);
			}
			if(stackP.size()!=stackQ.size()){
				return false;
			}
			if(tempP.left!=null){
				stackP.push(tempP.left);
			}
			if(tempQ.left!=null){
				stackQ.push(tempQ.left);
			}
			if(stackP.size()!=stackQ.size()){
				return false;
			}
		}
		return stackP.size()==stackQ.size();
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
