package other;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * **/
public class ValidParentheses {
	
	public boolean isValid(String s) {
        char[] list = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char temp : list){
        	if(temp=='(' || temp=='[' || temp=='{'){
        		stack.push(temp);
        	}
        	if(temp=='}' && (stack.isEmpty()||stack.pop()!='{')){
        		return false;
        	}
        	if(temp==')' && (stack.isEmpty()||stack.pop()!='(')){
        		return false;
        	}
        	if(temp==']'&& (stack.isEmpty()||stack.pop()!='[')){
        		return false;
        	}
        }
        if(!stack.isEmpty()){
        	return false;
        }
        return true;
    }
	
	//效率更高		
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
}
