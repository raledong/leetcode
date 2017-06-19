package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * 	"((()))",
 * 	"(()())",
 * 	"(())()",
 * 	"()(())",
 * 	"()()()"
 * ]
 */
public class GenerateParentheses_22 { 
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
        if(n<=0){
        	return result;
        }
        generateParenthesis(result, "(", n-1, n);
        return result;
        
    }
	
	private void generateParenthesis(List<String> result, String current, int leftRemainCount, int rightRemainCount){
		if(leftRemainCount==0){
			while(rightRemainCount-->0){
				current += ")";
			}
			result.add(current);
			return;
		}
		generateParenthesis(result, current+"(", leftRemainCount-1, rightRemainCount);
		if(rightRemainCount>leftRemainCount){
			generateParenthesis(result, current+")", leftRemainCount, rightRemainCount-1);
		}
	}
	
	public List<String> generateParenthesis2(int n) {
        List<String> rst = new ArrayList<>();
        if(n == 0) {
          return rst;     
        }
        backtracking(rst, new StringBuilder(), n, n);
        return rst;
    }
    private void backtracking(List<String> rst, StringBuilder sb, int left, int right) {
        if(left > right) {
          return;    
        }
        if(left > 0) {
          sb.append('(');
          backtracking(rst, sb, left - 1, right);
          sb.setLength(sb.length() - 1);
        }
        if(right > 0) {
          sb.append(')');
          backtracking(rst, sb, left, right - 1);
          sb.setLength(sb.length() - 1);
        }
        
        if(left == 0 && right == 0) {
          rst.add(sb.toString());  
        }
    }

	
	public static void main(String[] args){
		GenerateParentheses_22 g = new GenerateParentheses_22();
		g.generateParenthesis(3);
	}
}
