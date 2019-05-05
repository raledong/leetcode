package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rale
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * 
 * According to the example above:
 * 
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class EvaluateDivision_399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<String>> pairs = new HashMap<>();
		Map<String, List<Double>> valuedPairs = new HashMap<>();
		for(int i = 0 ; i < equations.size() ; i++) {
			//获取第i个方程式
			List<String> equation = equations.get(i);
			String multiplied = equation.get(0);
			String multiplier = equation.get(1);
			if(!pairs.containsKey(multiplied)) {
				pairs.put(multiplied, new ArrayList<>());
				valuedPairs.put(multiplied, new ArrayList<>());
			}
			if(!pairs.containsKey(multiplier)) {
				pairs.put(multiplier, new ArrayList<>());
				valuedPairs.put(multiplier, new ArrayList<>());
			}
			pairs.get(multiplied).add(multiplier);
			pairs.get(multiplier).add(multiplied);
			valuedPairs.get(multiplied).add(values[i]);
			valuedPairs.get(multiplier).add(1.0 / values[i]);
		}
		
		double[] result = new double[queries.size()];
		for(int i = 0 ; i<queries.size() ; i++) {
			result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), pairs, valuedPairs, new HashSet<>(), 1.0);
			result[i] = result[i]==0.0 ? -1.0 : result[i];
		}
        return result;
    }
	
	public double dfs(String multiplied, String multiplier, Map<String, List<String>> pairs, Map<String, List<Double>> valuedPairs, Set<String> visited, double curResult) {
		if(!pairs.containsKey(multiplied)) return 0.0;
		if(visited.contains(multiplied)) return 0.0;
		if(multiplied.equals(multiplier)) return curResult;
		visited.add(multiplied);
		List<String> multipliers = pairs.get(multiplied);
		List<Double> multiplierValues = valuedPairs.get(multiplied);
		double tmp = 0.0;
		for(int i = 0 ; i<multipliers.size() ; i++) {
			tmp = dfs(multipliers.get(i), multiplier, pairs, valuedPairs, visited, curResult * multiplierValues.get(i));
			if(tmp != 0.0){
				break;
			}
		}
		visited.remove(multiplied);
		return tmp;
	}
	
	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<List<String>>();
		equations.add(Arrays.asList("a", "b"));
		equations.add(Arrays.asList("b", "c"));
		double[] values = new double[]{2.0, 3.0};
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a", "c"));
		queries.add(Arrays.asList("b", "a"));
		queries.add(Arrays.asList("a", "e"));
		queries.add(Arrays.asList("a", "a"));
		queries.add(Arrays.asList("x", "x"));
		
		EvaluateDivision_399 e = new EvaluateDivision_399();
		double[] result = e.calcEquation(equations, values, queries);
		for(double d : result) {
			System.out.println(d);
		}
	}
}
