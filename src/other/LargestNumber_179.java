package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author rale
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber_179 {
	
	/**
	 * 插入排序
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
        for(int i = 1 ; i<nums.length ; i++){
			int cur = nums[i];
			int j = i;
			while(j>=1 && !lessThan(cur, nums[j-1])){ 
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = cur;
			
		}
        if(nums[0]==0) return "0";
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i<nums.length ; i++){
			result.append(nums[i]);
		}
		return result.toString();
    }
    
    public boolean lessThan(int n1, int n2){
    	if(n1==n2) return false;
        long r1 = n1;
        int temp = n2;
        do{
        	r1 = r1*10;
        	temp /= 10;
        }while(temp>0);
        r1 += n2;
        
        temp = n1;
        long r2 = n2;
        do{
        	r2 = r2 * 10;
        	temp /=10;
        }while(temp>0);
        r2 += n1;
        
        return r1<r2;
	}
    
    /**
     * 利用comparator api
     * @param nums
     * @return
     */
    public String largestNumber2(int[] nums){
    	String[] numS = new String[nums.length];
    	for(int i = 0; i<nums.length ; i++){
    		numS[i] = String.valueOf(nums[i]);
    	}
    	Arrays.sort(numS, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}
    		
    	});
    	if(numS[0].equals("0")) return "0";
    	StringBuilder result = new StringBuilder();
    	for(int i = 0 ; i<nums.length ; i++){
    		result.append(numS[i]);
    	}
    	return result.toString();
    }
    public static void main(String[] args){
    	LargestNumber_179 l = new LargestNumber_179();	
    }
}
