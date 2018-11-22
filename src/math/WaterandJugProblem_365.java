package math;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rale
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * 
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * 
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class WaterandJugProblem_365 {

	/**
	 * https://en.wikipedia.org/wiki/B%C3%A9zout%27s_identity
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean canMeasureWater(int x, int y, int z) {
		if(x == z || y == z || x + y == z) return true;
		if(x + y < z) return false;
		
		while( (x %= y) != 0 && (y %= x) != 0);
		return z % (x+y) == 0;
    }
	
	public class Status{
		private int x;
		private int y;
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getWater() {
			return this.getX() + this.getY();
		}
		
		public Status(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o==null || !(o instanceof Status)) return false;
			if(this == o) return true;
			Status s = (Status) o;
			return this.getX() == s.getX() && this.getY() == s.getY();
		}
		
		@Override
		public int hashCode() {
			return this.getX() + 17 * this.getY();
		}
	}
	
	Set<Status> statusSet = new HashSet<Status>();
	public boolean canMeasureWaterDFS(int x, int y, int z) {
		if(x + y < z) return false;
		if(x == z || y == z || x + y == z) return true;
		return canMeasureWaterDFS(x, y , new Status(0, 0), z);
	}
	
	public boolean canMeasureWaterDFS(int x, int y, Status curStatus, int z) {
		if(statusSet.contains(curStatus)) return false;
		else if(curStatus.getWater() == z) return true;
		else{
			statusSet.add(curStatus);
			
			return canMeasureWaterDFS(x, y, new Status(x, curStatus.getY()), z)
				|| canMeasureWaterDFS(x, y, new Status(curStatus.getX(), y), z)
				|| canMeasureWaterDFS(x, y, new Status(curStatus.getX(), 0), z)
				|| canMeasureWaterDFS(x, y, new Status(0, curStatus.getY()), z)
				|| canMeasureWaterDFS(x, y, new Status(
								curStatus.getX() - Math.min(curStatus.getX(), y-curStatus.getY()),
								curStatus.getY() + Math.min(curStatus.getX(), y-curStatus.getY())
						),
						z)
				|| canMeasureWaterDFS(x, y, new Status(
								curStatus.getX() + Math.min(x - curStatus.getX(), curStatus.getY()),
								curStatus.getY() - Math.min(x - curStatus.getX(), curStatus.getY())
						), 
						z);
		
		}
	}
	
	public static void main(String[] args) {
		WaterandJugProblem_365 w = new WaterandJugProblem_365();
		System.out.println(w.canMeasureWaterDFS(2, 6, 5));
	}
}
