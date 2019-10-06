package bitmanipulation;

public class TotalHammingDistance_477 {

	 public int totalHammingDistance(int[] nums) {
		 int count = 0;
		 int length = nums.length;
		 for(int i = 0 ; i<32 ; i++) {
	    	   int countOfOne = 0;
	    	   for(int j = 0 ; j < length ; j++) {
	    		   countOfOne += (nums[j] >> i) & 1;
	    	   }
	    	   count += countOfOne * (length - countOfOne);
	     } 
		 return count;
	 }
}
