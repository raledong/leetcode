package other;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryMutable_307 {
	private int[] sum;
	private int[] nums;
	private Map<Integer, Integer> log;
	public RangeSumQueryMutable_307(int[] nums) {
		this.nums = nums;
        sum = new int[nums.length];
        for(int i = 0 ; i<nums.length ; i++){
        	if(i==0) sum[i] = nums[i];
        	else sum[i] = sum[i-1] + nums[i];
        }
        
        log = new HashMap<Integer, Integer>();
    }
    
    public void update(int i, int val) {
    	log.put(i, val - nums[i]);
    }
    
    public int sumRange(int i, int j) {
    	int origin = 0;
    	if(i==0) origin = sum[j];
    	else origin = sum[j] - sum[i-1];
    	for(Integer key : log.keySet()){
    		if(key>=i && key <= j){
    			origin += log.get(key);
    		}
    	}
    	return origin;
    }
    
    public static void main(String[] args){
    	RangeSumQueryMutable_307 r = new RangeSumQueryMutable_307(new int[]{1,3,5});
    	r.sumRange(0, 2);
    	r.update(1, 2);
    	r.sumRange(0, 2);
    }
}
