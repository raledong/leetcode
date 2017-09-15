package math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsonaLine_149 {
	
	/**
	 * 将每个点作为起点分别遍历，至于标记一个节点，则通过直线的斜率即可
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {
		if(points==null) return 0;
		int num = points.length;
		if(num<=2) return num;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for(int i = 0 ; i<num ; i++){
           int max = 0, overlap = 0;
    	   map.clear();
    	   Point cur = points[i];
    	   for(int j = i+1 ; j<num ; j++){
    		   int x = points[j].x - cur.x;
    		   int y = points[j].y - cur.y;
    		   if(x==0 && y==0){
    			   overlap++;
    			   continue;
    		   }
    		   int gcd = generateGCD(x, y);
    		   if(gcd!=0){
    			   x /= gcd;
    			   y /= gcd;
    		   }
    		   if(map.containsKey(x)){
    			   if(map.get(x).containsKey(y)){
    				   map.get(x).put(y, map.get(x).get(y)+1);
    			   }else{
    				   map.get(x).put(y, 1);
    			   }
    		   }else{
    			   Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
    			   tempMap.put(y, 1);
    			   map.put(x, tempMap);
    		   }
    		   max = Math.max(max, map.get(x).get(y));
    	   }
    	   result = Math.max(result, max+overlap+1);
       }
       return result;
    }
	
	public int generateGCD(int a , int b){
		if(b==0) return a;
		return generateGCD(b, a%b);
	}
	
	
	public int maxPoints2(Point[] points) {
        int n = points.length;
        if(n < 3) return n;
        
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if(a.x == b.x) {
                    return a.y - b.y;
                }
                return a.x - b.x;
            }
        });
        
        //time optimization - true when pair has been checked
        boolean[][] checked = new boolean[n][n];
        int answer = 2;
        /*
            We will go through pairs of points, seeing how many points are on line connecting them.
            Since we sorted our array (primarily by x, then by y if the x values are equal), we know that any 
            point k that comes between i and j in our array must also be between points i and j on the plane.
            This means we can go through them in order, starting with the points that have the largest
            possible number of points on their line. 
        */
        for(int i=0; i<n; i++) {
            if(answer >= n-i) {
                /*
                    The greatest possible number of points we can have starting at i is n-i.
                    Since it's ordered, we have gone through our greatest possibilites first.
                */
                return answer;
            }
            Point a = points[i];
            for(int j=n-1; j>i; j--) {
                if (j - i + 1 <= answer || checked[i][j]) {
                    /*
                        Once the number of points we can check between i and j is less than
                        our current answer, we won't be able to do any better for this i.
                        We also can break if we checked this combination.
                    */
                    break;
                } 
                Point b = points[j];
                int pointCount = 2;
                for(int k=i+1; k<j; k++) {
                    //Check how many points on the line between point[i] and point[j]
                    if(pointCount + j - k <= answer) break;
                    if(pointOnLine(a, b, points[k])) {
                        checked[i][k] = true;
                        checked[k][j] = true;
                        pointCount++;
                    }    
                }
                answer = Math.max(pointCount, answer);
            }
        }
        return answer;
    }
    private boolean pointOnLine(Point a, Point b, Point check) {
        return (long) (check.x - a.x) * (b.y - check.y) == (long) (b.x - check.x) * (check.y - a.y);
    }
}
