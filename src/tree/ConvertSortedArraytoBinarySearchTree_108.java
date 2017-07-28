package tree;


/**
 * @author rale
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0) return null;
		TreeNode t = sortedArrayToBST(nums, 0, nums.length-1);
		return t;
    }
	
	public TreeNode sortedArrayToBST(int[] nums, int start, int end){
		if(start>end) return null;
		if(start==end)return new TreeNode(start);
		int mid = (start + end + 1) / 2;
		TreeNode t = new TreeNode(nums[mid]);
		t.left = sortedArrayToBST(nums, start, mid-1);
		t.right = sortedArrayToBST(nums, mid+1, end);
		return t;
	}
}
