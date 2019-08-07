package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author rale
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
 

Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
 

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
 */
public class MinimumGeneticMutation_433 {
	
	public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> bankSet = new HashSet<String>();
        for(String item : bank) {
        	bankSet.add(item);
        }
        
        int round = 0;
        queue.add(start);
        while(!queue.isEmpty()) {
        	int numberOfGenes = queue.size();
        	while(numberOfGenes-- > 0){
        		String tmp = queue.poll();
            	if(tmp.equals(end)) {
            		return round;
            	}
            	Iterator<String> iterator = bankSet.iterator();
            	while(iterator.hasNext()) {
            		String cur = iterator.next();
            		int count = 0;
            		for(int i = 0 ; i<start.length() ; i++) {
            			char c1 = tmp.charAt(i);
            			char c2 = cur.charAt(i);
            			if(c1 != c2 && ++count > 1) {
            				break;
            			}
            		}
            		if(count == 1) {
            		    queue.offer(cur);
            			iterator.remove();
            		}
            	}
        	}
        	round++;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		MinimumGeneticMutation_433 m = new MinimumGeneticMutation_433();
		m.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
	}
}
