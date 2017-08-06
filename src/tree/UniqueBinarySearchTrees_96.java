package tree;

/**
 * @author rale
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees_96 {
	public int numTrees(int n) {
		int[] nums = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
        	if(i==0 || i==1) nums[i] = 1;
        	else{
        		for(int j = 1 ; j<=i ; j++){
        			nums[i] += nums[j-1]*nums[i-j];
        		}
        	}
        }
        return nums[n];
    }
}
