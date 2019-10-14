package other;

/**
 * @author rale
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.

**Example:**

**Input:** [4, 6, 7, 7]
**Output:** [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

**Note:**

1.  The length of the given array will not exceed 15.
2.  The range of integer in the given array is [-100,100].
3.  The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class IncreasingSubsequences_491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(nums, new LinkedList<>(), 0, result);
        return result;
    }

    public void findSubsequences(int[] nums, LinkedList<Integer> subSequence, int startIndex, List<List<Integer>> result) {
        if (subSequence.size() >= 2) {
            result.add(new LinkedList<>(subSequence));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex ; i<nums.length ; i++) {
            if (used.contains(nums[i])) {continue;}
            if (subSequence.size() == 0 || nums[i] >= subSequence.peekLast()) {
                used.add(nums[i]);
                subSequence.add(nums[i]);
                findSubsequences(nums, subSequence, i+1, result);
                subSequence.removeLast();
            }

        }
    }
}
