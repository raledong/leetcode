package math;

import java.util.PriorityQueue;

/**
 * @author rale
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber_313 {
	
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] index = new int[primes.length];
		int[] uglyNumbers = new int[primes.length];
		System.arraycopy(primes, 0, uglyNumbers, 0, primes.length);
		
		int[] result = new int[n];
		result[0] = 1;
		for(int i = 1 ; i<n ; i++){
			result[i] = Integer.MAX_VALUE;
			for(int j = 0 ; j<uglyNumbers.length ; j++){
				if(uglyNumbers[j] < result[i]) result[i] = uglyNumbers[j];
			}
			for(int j = 0 ; j <uglyNumbers.length ; j++){
				if(uglyNumbers[j]==result[i]) {
					index[j]++;
					uglyNumbers[j] = primes[j] * result[index[j]];
				}
			}
		}
		return result[n-1];
    }
	
	public int nthSuperUglyNumberHeap(int n, int[] primes) {
	    int[] ugly = new int[n];

	    PriorityQueue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
	    ugly[0] = 1;

	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }

	    return ugly[n - 1];
	}

	private class Num implements Comparable<Num> {
	    int val;
	    int idx;
	    int p;

	    public Num(int val, int idx, int p) {
	        this.val = val;
	        this.idx = idx;
	        this.p = p;
	    }

	    @Override
	    public int compareTo(Num that) {
	        return this.val - that.val;
	    }
	}
	public static void main(String[] args){
		SuperUglyNumber_313 s = new SuperUglyNumber_313();
		s.nthSuperUglyNumber(3, new int[]{2,3,5});
	}
}
