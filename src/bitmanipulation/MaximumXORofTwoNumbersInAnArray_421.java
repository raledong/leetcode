package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rale
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXORofTwoNumbersInAnArray_421 {
	 
	public int findMaximumXOR(int[] nums) {
		int maxResult = 0;
		int mask = 0;
		for(int i = 31 ; i>=0 ; i--) {
			mask |= (1 << i);
			Set<Integer> set = new HashSet<>();
			for(int num : nums) {
				set.add(num | mask);
			}
			
			int greedyTry = maxResult | (1 << i);
			for(int num : set) {
				if(set.contains(greedyTry ^ num)) {
					maxResult = greedyTry;
					break;
				}
			}
		}
		return maxResult;

	}
	
	public int findMaximumXOR2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        TrieNode root = new TrieNode(-1);
        for (int i = 0; i < nums.length; i += 1) {
            addToTrie(root, nums[i]);
        }
        return findMaximum(root, 31);
    }
    
    private int findMaximum(TrieNode node, int pos) {
        if (pos == 0) {
            return 0;
        }
        
        if (node.zero == null) {
            return findMaximum(node.one, pos - 1);
        }
        if (node.one == null) {
            return findMaximum(node.zero, pos - 1);
        }
        return findMaximum(node.zero, node.one, pos - 1);
    }
    
    private int findMaximum(TrieNode node1, TrieNode node2, int pos) {
        int result = (node1.val ^ node2.val) << pos;
        if (pos == 0) {
            return result;
        }
        
        TrieNode next1 = null;
        TrieNode next2 = null;
        if (node1.zero != null && node1.one == null) {
            next1 = node1.zero;
        } else if (node1.zero == null && node1.one != null) {
            next1 = node1.one;
        }
        if (node2.zero != null && node2.one == null) {
            next2 = node2.zero;
        } else if (node2.zero == null && node2.one != null) {
            next2 = node2.one;
        }
        if (next1 != null && next2 != null) {
            return result + findMaximum(next1, next2, pos - 1);
        }
        if (next1 != null) {
            if (next1.val == 0) {
                next2 = node2.one;
            } else {
                next2 = node2.zero;
            }
            return result + findMaximum(next1, next2, pos - 1);
        }
        if (next2 != null) {
            if (next2.val == 0) {
                next1 = node1.one;
            } else {
                next1 = node1.zero;
            }
            return result + findMaximum(next1, next2, pos - 1);
        }
        return result + Math.max(findMaximum(node1.zero, node2.one, pos - 1), findMaximum(node1.one, node2.zero, pos - 1));
    }
    
    private void addToTrie(TrieNode root, int x) {
        TrieNode curr = root;
        int[] binary = toBinary(x);
        for (int i = 0; i < binary.length; i += 1) {
            if (binary[i] == 0) {
                if (curr.zero == null) {
                    curr.zero = new TrieNode(0);
                }
                curr = curr.zero;
            } else {
                if (curr.one == null) {
                    curr.one = new TrieNode(1);
                }
                curr = curr.one;
            }
        }
    }
    
    private int[] toBinary(int x) {
        int[] result = new int[31];
        for (int i = 30; i >= 0; i -= 1) {
            result[i] = x & 1;
            x >>= 1;
        }
        return result;
    }
    
    static class TrieNode {
        int val;
        TrieNode zero;
        TrieNode one;
        
        public TrieNode(int val) {
            this.val = val;
            zero = null;
            one = null;
        }
    }
}
