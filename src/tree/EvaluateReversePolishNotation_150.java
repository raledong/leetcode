package tree;

import java.util.LinkedList;

/**
 * @author rale
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * 	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation_150 {
	
	//stack
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(String token : tokens){
			if(token.equals("+")){
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 + operand1);
			}else if(token.equals("-")){
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 - operand1);
			}else if(token.equals("*")){
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 * operand1);
			}else if(token.equals("/")){
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 / operand1);
			}else{
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
    }
	
	//recursive
	int index;
	public int evalRPN2(String[] tokens){
		index = tokens.length-1;
		return recursive(tokens);
	} 
	public int recursive(String[] tokens){
		String current = tokens[index--];
		int operand1, operand2;
		switch(current){
		case "+" : 
			operand1 = recursive(tokens);
			operand2 = recursive(tokens);
			return operand1 + operand2;
		case "-" :
			operand1 = recursive(tokens);
			operand2 = recursive(tokens);
			return operand2 - operand1;
		case "*" :
			operand1 = recursive(tokens);
			operand2 = recursive(tokens);
			return operand2 * operand1;
		case "/" :
			operand1 = recursive(tokens);
			operand2 = recursive(tokens);
			return operand2 / operand1;
		default:
			return Integer.valueOf(current);
		}
	}
}
