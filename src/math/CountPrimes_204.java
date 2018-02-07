package math;

/**
 * @author rale
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes_204 {
	public int countPrimes(int n) {
        int count = 0;
        boolean[] isNotPrime = new boolean[n];
        for(int i = 2 ; i<n ; i++){
        	if(!isNotPrime[i]){
        		count++;
        		for(int j = 2 ; i*j<n ; j++){
        			isNotPrime[i*j] = true;
        		}
        	}
        }
        return count;
    }
}
