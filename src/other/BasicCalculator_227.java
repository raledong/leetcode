package other;

import java.util.Stack;

/**
 * @author rale
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */
public class BasicCalculator_227 {
	
	public int calculate(String s) {
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operations = new Stack<Character>();
		char[] sArray = s.toCharArray();
		for(int i = 0 ; i<sArray.length ; i++){
			char cur = sArray[i];
			if(cur == ' ') continue;
			else if(cur == '*' || cur == '/') operations.push(cur);
			else if(cur == '+' || cur == '-'){
				if(!operations.isEmpty()){
					char operation = operations.pop();
					int secondOperand = operands.pop();
					int firstOperand = operands.pop();
					int value = 0;
					switch(operation){
					case '+' : value = firstOperand + secondOperand; break;
					case '-' : value = firstOperand - secondOperand; break;
 					}
					operands.push(value);
				}
				operations.push(cur);
			}else if(Character.isDigit(cur)){
				int value = cur - '0';
				while(i+1<sArray.length && Character.isDigit(sArray[i+1])){
					value = value * 10 + sArray[++i] - '0';
				}
				if(!operations.isEmpty() && (operations.peek() == '*' || operations.peek() == '/')){
					char operation = operations.pop();
					int firstOperand = operands.pop();
					switch(operation){
					case '*' : value = firstOperand * value; break;
					case '/' : value = firstOperand / value; break;
					}
				}
				operands.push(value);
			}
		}
		if(!operations.isEmpty()){
			char operation = operations.pop();
			int secondOperand = operands.pop();
			int firstOperand = operands.pop();
			int value = 0;
			switch(operation){
				case '+' : value = firstOperand + secondOperand; break;
				case '-' : value = firstOperand - secondOperand; break;
			}
			return value;
		}
		return operands.pop();
    }
	
	//用一个栈实现
	public int calculate2(String s) {
		int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int re = 0;
	    for(int i:stack){
	        re += i;
	    }
	    return re;
    }
	
	public static void main(String[] args){
		BasicCalculator_227 b = new BasicCalculator_227();
		b.calculate2("1*2");
	}
}
