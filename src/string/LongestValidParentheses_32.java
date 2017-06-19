package string;

import java.util.Stack;

/**
 * @author rale
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses_32 {
	
	//method 1 stack
	public int longestValidParentheses(String s) {
		Stack<Parenthese> parenthesesStack = new Stack<Parenthese>();
        for(int i = 0 ; i < s.length() ; i++){
        	char symbol = s.charAt(i);
        	if(symbol==')'){
        		if(!parenthesesStack.isEmpty() && parenthesesStack.peek().symbol=='('){
        			parenthesesStack.pop();
        			continue;
        		}
        	}
        	parenthesesStack.push(new Parenthese(symbol, i));
        }
        int maxLength = 0;
        int nextIndex = s.length();
        while(!parenthesesStack.isEmpty()){
        	int curIndex = parenthesesStack.pop().index;
        	maxLength = (nextIndex-curIndex-1)>maxLength ? nextIndex-curIndex-1 : maxLength;
        	nextIndex = curIndex;
        }
        return Math.max(nextIndex, maxLength);
    }
	public class Parenthese{
		char symbol;
		int index;
		public Parenthese(char symbol, int index){
			this.symbol = symbol;
			this.index = index;
		}	
	}
	
	//不使用数据结构
	public int longestValidParentheses_noDataStructure(String s) {
		Stack<Integer> parenthesesStack = new Stack<Integer>();
        for(int i = 0 ; i < s.length() ; i++){
        	if(s.charAt(i)==')'){
        		if(!parenthesesStack.isEmpty() && s.charAt(parenthesesStack.peek())=='('){
        			parenthesesStack.pop();
        			continue;
        		}
        	}
        	parenthesesStack.push(i);
        }
        int maxLength = 0;
        int nextIndex = s.length();
        while(!parenthesesStack.isEmpty()){
        	int curIndex = parenthesesStack.pop();
        	int curLength = nextIndex-curIndex-1;
        	maxLength = curLength>maxLength ? curLength : maxLength;
        	nextIndex = curIndex;
        }
        return Math.max(nextIndex, maxLength);
    }
	
	//dynamic programming 的思路
	public int longestValidParentheses_dynamicProgramming(String s) {
		int[] maxCount = new int[s.length()];
		int maxLength = 0;
		for(int i = 1 ; i<s.length() ; i++){
			if(s.charAt(i) == ')'){
				if(s.charAt(i-1)=='('){
					maxCount[i] = (i>=2? maxCount[i-2]+2 : 2);
					maxLength = Math.max(maxCount[i], maxLength);
				}else{
					if(i-maxCount[i-1]-1>=0 && s.charAt(i-maxCount[i-1]-1)=='('){
						maxCount[i] = maxCount[i-1]+2 + ((i-maxCount[i-1]-2 >= 0)?maxCount[i-maxCount[i-1]-2]:0);;
						maxLength = Math.max(maxCount[i], maxLength);
					}
				}
			}
		}
		return maxLength;		
	}
	//dynamic programming 的思路
	public int longestValidParentheses_dynamicProgrammingConcise(String s) {
		int[] maxCount = new int[s.length()];
		int maxLength = 0;
		for(int i = 1 ; i<s.length() ; i++){
			if(s.charAt(i) == ')' && i-maxCount[i-1]-1>=0 && s.charAt(i-maxCount[i-1]-1)=='('){
				maxCount[i] = maxCount[i-1] + 2 + ((i-maxCount[i-1]-2>=0) ? maxCount[i-maxCount[i-1]-2] : 0);
				maxLength = Math.max(maxCount[i], maxLength);
				
			}
		}
		return maxLength;		
	}
}
