package math;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
	public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>(n);
        for(int i = 1 ; i<=9 ; i++) {
        	lexicalOrder(n, i, result);
        }
        return result;
    }
	
	public void lexicalOrder(int n, int cur, List<Integer> result) {
		if(cur > n) return;
		result.add(cur);
		for(int i = 0 ; i <=9 ; i++) {
			lexicalOrder(n, cur*10+i, result);
		}
	}
}
