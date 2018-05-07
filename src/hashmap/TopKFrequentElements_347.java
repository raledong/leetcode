package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements_347 {
	
	//bucket sort
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] buckets = new List[nums.length + 1];
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		
		for(int num : nums){
			frequency.put(num, frequency.getOrDefault(num, 0) + 1);
		}
		
		for(int key : frequency.keySet()){
			int frequencyOfKey = frequency.get(key);
			if(buckets[frequencyOfKey] == null){
				buckets[frequencyOfKey] = new ArrayList<Integer>();
			}
			buckets[frequencyOfKey].add(key);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i = buckets.length-1 ; i>=0 && k>result.size() ; i--){
			if(buckets[i] != null){
				result.addAll(buckets[i]);
			}
		}
		return result;
    }
	
	public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || k == 0) {
            return res;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] buckets = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - min]++;
        }
        List[] counting = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            int sizeOfBucket = buckets[i];
            if (counting[sizeOfBucket] == null) {
                counting[sizeOfBucket] = new ArrayList<Integer>();
            }
            counting[sizeOfBucket].add(i + min);
        }
        for (int i = counting.length - 1; i >= 0; i--) {
            if (counting[i] != null) {
                for (Integer in:(ArrayList<Integer>)counting[i]) {
                    res.add(in);
                    if (res.size() == k) break;
                }
            }
            if (res.size() == k) break;
        }
        return res;
    }
}
