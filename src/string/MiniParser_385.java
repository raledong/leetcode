package string;

import java.util.Stack;

public class MiniParser_385 {
	public NestedInteger deserialize(String s) {
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger cur = null;
		int l = 0 , r = 0;
		for(; r<s.length() ; r++) {
			char c = s.charAt(r);
			if(c == '[') {
				if(cur != null) {
					stack.push(cur);
				}
				cur = new NestedInteger();
				l = r + 1;
			}else if(c == ']') {
				String number = s.substring(l, r);
				if(!number.isEmpty()) {
					cur.add(new NestedInteger(Integer.valueOf(number)));
				}
				if(!stack.isEmpty()) {
					NestedInteger parent = stack.pop();
					parent.add(cur);
					cur = parent;
				}
				l = r + 1;
			}else if(c==',') {
				if(s.charAt(r-1) != ']') {
					String number = s.substring(l, r);
					cur.add(new NestedInteger(Integer.valueOf(number)));
				}
				l = r + 1;
			}
		}
		if(l != r) {
			cur = new NestedInteger(Integer.valueOf(s.substring(l, r)));
		}
		return cur;
    }
	
	public static void main(String[] args) {
		MiniParser_385 m = new MiniParser_385();
		m.deserialize("[]");
	}
}
