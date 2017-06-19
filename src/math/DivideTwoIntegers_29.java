package math;

/**
 * @author rale
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers_29 {
	public int divide(int dividend, int divisor) {
		boolean isPositive = true;
		if((dividend<0&&divisor>0) || (dividend>0&&divisor<0)){
			isPositive = false;
		}
		
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);
		if(ldivisor==0) return Integer.MAX_VALUE;
		if(ldividend==0 || ldividend<ldivisor) return 0;
		
		long result = divide(ldividend, ldivisor);
		if(result>Integer.MAX_VALUE){
			return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return (int)(isPositive? result : -result);
    }
	
	public long divide(long ldividend, long ldivisor){
		if(ldividend<ldivisor) return 0;
		long sum = ldivisor;
		long result = 1;
		while(ldividend >= (sum+sum)){
			sum += sum;
			result += result;
		}
		return result + divide(ldividend-sum, ldivisor);
	}
}
