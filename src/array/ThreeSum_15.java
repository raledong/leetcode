package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rale
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * 	[-1, 0, 1],
 * 	[-1, -1, 2]
 * ]
 */
public class ThreeSum_15 {

	public List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0 ; i<length-2 ; i++){	
			for(int j = i+1 ; j<length-1 ; j++){
				int pointer = length - 1;
				while(pointer > j){
					int value = nums[i] + nums[j] + nums[pointer];
					if(value == 0){
						List<Integer> tempResult = new ArrayList<Integer>();
						tempResult.add(nums[i]);
						tempResult.add(nums[j]);
						tempResult.add(nums[pointer]);
						result.add(tempResult);
						break;
					}else if(value < 0 ){
						break;
					}
					pointer--;
				}
				while(j<nums.length-1 && nums[j]==nums[j+1]){
					j++;
				}
			}
			while(i<nums.length-1 && nums[i]==nums[i+1]){
				i++;
			}
		}
		return result;
    }
	
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int length = nums.length;
		if(length<3){
			return result;
		}
		Arrays.sort(nums);

		int i = 0;
		while(i<length-2){
			if(nums[i]>0) break;
			int j = i+1;
			int k = nums.length - 1;
			while(j<k){
				int sums = nums[i] + nums[j] + nums[k];
				if (sums==0){
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
				}
				if (sums<=0){
					//消去左侧重复的数字
					while(nums[j]==nums[++j] && j < k);
				}
				if (sums>=0){
					//消去右侧重复的数字
					while(nums[k--] == nums[k] && j < k);
				}
				
				//消去和当前左指针相同的数字
				while(nums[i] == nums[++i] && i < nums.length - 2);
			}
			
		}
		return result;
	}
	
	public static void main(String[] args){
		ThreeSum_15 t = new ThreeSum_15();
		System.out.println(t.threeSum2(new int[]{-1,0,0,1}));
	}
}
