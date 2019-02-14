package binarysearch;

import java.util.PriorityQueue;

/**
 * 
 * @author rale
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:
 * 
 * matrix = [
 * 	[ 1,  5,  9],
 * 	[10, 11, 13],
 * 	[12, 13, 15]
 * ],
 * 
 * k = 8,
 * return 13.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementinaSortedMatrix_378 {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
        for(int i = 0 ; i<matrix.length ; i++) {
        	queue.offer(new Tuple(i, 0, matrix[i][0]));
        }
        
        for(int i = 0 ; i<k-1 ; i++) {
        	Tuple t = queue.poll();
        	if(t.y == matrix[0].length-1) continue;
        	queue.offer(new Tuple(t.x, t.y+1, matrix[t.x][t.y+1]));
        }
        return queue.poll().value;
    }
	
	public static class Tuple implements Comparable<Tuple>{
		int x;
		int y;
		int value;
		
		public Tuple(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public int compareTo(Tuple o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	public int kthSmallest2(int[][] matrix, int k){
		int low = matrix[0][0], high = matrix[matrix.length-1][matrix[0].length-1];
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			int i = matrix.length-1 , j = 0;
			while(i>=0 && j < matrix.length){
	            if(matrix[i][j]>mid) i--;
	            else{
	                count+=i+1;
	                j++;
	            }
	        }
			if(count < k) {
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		KthSmallestElementinaSortedMatrix_378 k = new KthSmallestElementinaSortedMatrix_378();
		k.kthSmallest2(new int[][]{
			{1,5,9},
			{10,11,13},
			{12,13,15}
		}, 1);
	}
	
}
