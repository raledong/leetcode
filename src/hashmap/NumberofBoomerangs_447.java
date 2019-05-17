package hashmap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given n points in the plane that are all pairwise distinct, 
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k 
 * (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * 
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberofBoomerangs_447 {
	public int numberOfBoomerangs(int[][] points) {
		int result = 0;
		Map<Integer, Integer> distMap = new HashMap<>();
		for(int i = 0 ; i<points.length ; i++) {
    	   for(int j = 0 ; j<points.length ; j++) {
    		   int dist = getDistance(points[i], points[j]);
    		   distMap.put(dist, distMap.getOrDefault(dist, 0) + 1);
    	   }
    	   
    	   for(int val : distMap.values()) {
               result += val * (val-1);
           }   
    	   distMap.clear();
       
		}	
		return result;
	}
	
	public int getDistance(int[] p1, int[] p2) {
		return (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
	}
	
	
}
