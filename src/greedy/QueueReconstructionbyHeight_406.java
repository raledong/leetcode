package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author rale
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionbyHeight_406 {

	public int[][] reconstructQueue(int[][] people) {
		int[][] result = new int[people.length][2];
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
			
		});
		for(int i = 0 ; i<people.length ; i++) {
			int pos = people[i][1];
			for (int j = i; j > pos; j--) {
                result[j] = result[j - 1];
            }	
			result[pos] = people[i];
		}
		return result;
    }
	
	public static void main(String[] args) {
		QueueReconstructionbyHeight_406 q = new QueueReconstructionbyHeight_406();
		q.reconstructQueue(new int[][]{
			{7,0},
			{4,4},
			{7,-1}
		});
	}
	
}
