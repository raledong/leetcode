package divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class DifferentWaystoAddParentheses_241 {
	public List<Integer> diffWaysToCompute(String input) {
		return diffWaysToCompute(input, 0, input.length());
    }
	
	public List<Integer> diffWaysToCompute(String input, int startIndex, int endIndex){
		boolean isDigit = true;
		List<Integer> result = new ArrayList<Integer>();
		for(int i = startIndex ; i<endIndex ; i++){
			char cur = input.charAt(i);
			if(cur == '+' || cur == '-' || cur=='*' ){
				isDigit = false;
				List<Integer> leftValue = diffWaysToCompute(input, startIndex, i);
				List<Integer> rightValue = diffWaysToCompute(input, i+1, endIndex);
				result.addAll(compute(leftValue, rightValue,cur));
			}
		}
		if(isDigit){
			result.add(Integer.parseInt(input.substring(startIndex, endIndex)));
		}
		return result;
	}
	
	public List<Integer> compute(List<Integer> leftValue, List<Integer> rightValue, char operator){
		switch(operator){
		case '+' : return add(leftValue, rightValue);
		case '-' : return minus(leftValue, rightValue);
		case '*' : return multiply(leftValue, rightValue);
		}
		return new ArrayList<>();
	}
	
	public List<Integer> add(List<Integer> leftValue, List<Integer> rightValue){
		List<Integer> result = new ArrayList<Integer>();
		for(int left : leftValue){
			for(int right : rightValue){
				result.add(left + right);
			}
		}
		return result;
	}
	
	public List<Integer> minus(List<Integer> leftValue, List<Integer> rightValue){
		List<Integer> result = new ArrayList<Integer>();
		for(int left : leftValue){
			for(int right : rightValue){
				result.add(left - right);
			}
		}
		return result;
	}
	
	public List<Integer> multiply(List<Integer> leftValue, List<Integer> rightValue){
		List<Integer> result = new ArrayList<Integer>();
		for(int left : leftValue){
			for(int right : rightValue){
				result.add(left * right);
			}
		}
		return result;
	}
	
	Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();
	public List<Integer> diffWaysToCompute_withCache(String input){
		if(cache.containsKey(input)) return cache.get(input);
		List<Integer> result = new ArrayList<Integer>();
		boolean isDigit = true;
		for(int i = 0 ; i<input.length() ; i++){
			int cur = input.charAt(i);
			if(cur == '+' || cur == '-' || cur == '*'){
                isDigit = false;
				List<Integer> leftValues = diffWaysToCompute_withCache(input.substring(0, i));
				List<Integer> rightValues = diffWaysToCompute_withCache(input.substring(i+1));
				for(Integer left : leftValues){
					for(Integer right : rightValues){
						switch(cur){
						case '+' : result.add(left + right); break;
						case '-' : result.add(left - right); break;
						case '*' : result.add(left * right); break;
						}
					}
				}
			}
		}
		if(isDigit){ result.add(Integer.parseInt(input));}
		cache.put(input, result);
		return result;
	}
	public static void main(String[] args){
		DifferentWaystoAddParentheses_241 d = new DifferentWaystoAddParentheses_241();
		d.diffWaysToCompute("2-1-1");
	}
}
