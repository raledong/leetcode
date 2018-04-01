package divideandconquer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
public class CountofSmallerNumbersAfterSelf_315 {
	public List<Integer> countSmaller(int[] nums) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if(nums.length == 0) return result;
        SpecialTreeNode root = new SpecialTreeNode(nums[nums.length-1]);
        result.addFirst(0);
        for(int i = nums.length-2 ; i>=0 ; i--){
        	int count = insert(root, nums[i]);
            result.addFirst(count);
        }
        return result;
    }
	
	private int insert(SpecialTreeNode root, int val){
		if(val == root.val){
			root.addDuplicate();
			return root.smallerThan;
		}else if(val < root.val){
			root.addSmallerThan();
			if(root.left==null){
				SpecialTreeNode s = new SpecialTreeNode(val);
				root.left = s;
				return 0;
			}else{
				return insert(root.left, val);
			}
		}else{
			if(root.right == null){
				SpecialTreeNode s = new SpecialTreeNode(val);
				root.right = s;
				return root.smallerThan + root.duplicateCount;
			}else{
				return root.smallerThan + root.duplicateCount + insert(root.right, val);
			}
		}
		
	}
	class SpecialTreeNode{
		int val = 0, smallerThan = 0, duplicateCount = 1;
		SpecialTreeNode left;
		SpecialTreeNode right;
		
		SpecialTreeNode(int val){
			this.val = val;
		}
		
		void addDuplicate(){
			this.duplicateCount++;
		}
		
		void addSmallerThan(){
			this.smallerThan++;
		}
	}
}
