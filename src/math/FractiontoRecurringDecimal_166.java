package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractiontoRecurringDecimal_166 {
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator>0) return "0";
 		StringBuilder result = new StringBuilder();
		if(numerator>0 ^ denominator>0) result.append("-");
		
		
		long numeratorL = Math.abs((long)numerator) ;
		long denominatorL = Math.abs((long)denominator);
		long gcd = generateGCD(numeratorL, denominatorL);
		numeratorL /= gcd;
		denominatorL /= gcd;

		result.append((numeratorL / denominatorL) + "");
		long remain = numeratorL % denominatorL;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringBuilder remainSB = new StringBuilder();
		map.put((int) remain, 0);
        int index = 1;
		while(remain!=0){
			remain *= 10;
			int current = (int) (remain % denominatorL);
			remainSB.append(remain/denominatorL);
			if(map.containsKey(current)) break;
            map.put(current, index++);
			remain %= denominatorL;
		}
		if(remain==0) return remainSB.length()==0 ? result.toString() : result.append(".").append(remainSB).toString();
        index = map.get((int)(remain%denominatorL));
        remainSB.insert(index, "(");
        remainSB.append(")");
        return result.append(".").append(remainSB).toString();
    }
	
	public long generateGCD(long a, long b){
		if(b==0) return a;
		return generateGCD(b, a%b);
	}
	
	public static void main(String[] args){
		FractiontoRecurringDecimal_166 f = new FractiontoRecurringDecimal_166();
		System.out.print(f.fractionToDecimal(1, 6));
	}
}
