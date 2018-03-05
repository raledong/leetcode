package divideandconquer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
public class ExpressionAddOperators_282 {
	
	
	void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
	    if (pos == digits.length) {
	        if (left + cur == target) ret.add(new String(path, 0, len));
	        return;
	    }
	    long n = 0;
	    int j = len + 1;
	    for (int i = pos; i < digits.length; i++) {
	        n = n * 10 + digits[i] - '0';
	        path[j++] = digits[i];
	        path[len] = '+';
	        dfs(ret, path, j, left + cur, n, digits, i + 1, target);
	        path[len] = '-';
	        dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
	        path[len] = '*';
	        dfs(ret, path, j, left, cur * n, digits, i + 1, target);
	        if (digits[pos] == '0') break; 
	    }
	}
	public List<String> addOperators(String num, int target) {
	    List<String> ret = new LinkedList<>();
	    if (num.length() == 0) return ret;
	    char[] path = new char[num.length() * 2 - 1];
	    char[] digits = num.toCharArray();
	    long n = 0;
	    for (int i = 0; i < digits.length; i++) {
	        n = n * 10 + digits[i] - '0';
	        path[i] = digits[i];
	        dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
	        if (n == 0) break;
	    }
	    return ret;
	}
	
	public static void main(String[] args){
		ExpressionAddOperators_282 e = new ExpressionAddOperators_282();
		e.addOperators("123", 6);
	}
	
	
	 
	 
}
