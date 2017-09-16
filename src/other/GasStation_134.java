package other;

/**
 * @author rale
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation_134 {
	
	/**
	 * I have thought for a long time and got two ideas:
	 * If car starts at A and can not reach B. Any station between A and B
	 * can not reach B.(B is the first station that A can not reach.)
	 * If the total number of gas is bigger than the total number of cost. There must be a solution.
	 * (Should I prove them?)
	 * Here is my solution based on those ideas:
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int num = gas.length;
		int start = 0, total = 0, tank = 0;
		for(int i = 0 ; i<num ; i++){
			if((tank=tank+gas[i]-cost[i]) < 0){
				start = i + 1;
				total += tank;
				tank = 0;
			}
		}
		
		return total+tank<0 ? -1 : start;
    }
}
