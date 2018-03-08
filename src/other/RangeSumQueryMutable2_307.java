package other;

/**
 * @author rale
 *
 */
public class RangeSumQueryMutable2_307 {
	class SegmentTreeNode{
		int start;
		int end;
		SegmentTreeNode left;
		SegmentTreeNode right;
		int sum;
		
		public SegmentTreeNode(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end){
		if(start > end) return null;
		SegmentTreeNode cur = new SegmentTreeNode(start, end);
		if(start == end) cur.sum = nums[start];
		else{
			int mid = (start + end) / 2;
			cur.left = buildSegmentTree(nums, start, mid);
			cur.right = buildSegmentTree(nums, mid+1, end);
			cur.sum = cur.left.sum + cur.right.sum;
		}
		return cur;
	}
	
	private SegmentTreeNode root;
	public RangeSumQueryMutable2_307(int[] nums) {
        this.root = buildSegmentTree(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int position, int val){
    	if(root.start == root.end){
    		root.sum = val;
    	}else{
    		int mid = (root.start + root.end) / 2;
    		if(position <= mid){
    			update(root.left, position, val);
    		}else{
    			update(root.right, position, val);
    		}
    		root.sum = root.left.sum + root.right.sum;
    	}
    }
    
    public int sumRange(int i, int j) {
    	return sumRange(root, i, j);
    }	
    
    public int sumRange(SegmentTreeNode root, int i, int j){
    	if(root.start==i && root.end==j){
    		return root.sum;
    	}
    	int mid = (root.start + root.end )/2;
		if(j<=mid){
			return sumRange(root.left, i, j);
		}else if(i>mid){
			return sumRange(root.right, i, j);
		}else{
			return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
		}
    }
    
    
    public static void main(String[] args){
    	RangeSumQueryMutable2_307 r = new RangeSumQueryMutable2_307(new int[]{1,3,5});
    	r.sumRange(0, 2);
    }
    
    //i++是因为这里的二叉搜索树从1作为起始下标
    //binary indexed tree;
    class NumArray {
    	   int[] nums;
    		int[] BIT;
    		int n;

    		public NumArray(int[] nums) {
    			this.nums = nums;

    			n = nums.length;
    			BIT = new int[n + 1];
    			for (int i = 0; i < n; i++)
    				init(i, nums[i]);
    		}

    		//每次更新当前节点的同时更新父节点
    		public void init(int i, int val) {
    			i++;
    			while (i <= n) {
    				BIT[i] += val;
    				i += (i & -i);
    			}
    		}

    		//更新当前节点，同时将改变传递给父节点
    		void update(int i, int val) {
    			int diff = val - nums[i];
    			nums[i] = val;
    			init(i, diff);
    		}

    		//
    		public int getSum(int i) {
    			int sum = 0;
    			i++;
    			while (i > 0) {
    				sum += BIT[i];
    				i -= (i & -i);
    			}
    			return sum;
    		}

    		public int sumRange(int i, int j) {
    			return getSum(j) - getSum(i - 1);
    		}
    	}
}
