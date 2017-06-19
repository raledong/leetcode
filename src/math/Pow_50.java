package math;

public class Pow_50 {

	public double myPow(double x, int n) {
		if(x==0) return 0;
		if(n==0) return 1;
			
		x = n>0 ? x : 1/x;
		n = Math.abs(n);
		if(n%2!=0){
			return x*myPow(x, n-1);
		}
		long temp = 1;
		double result = x;
		while(n >= (temp+temp)){
			temp += temp;
			result *= result;
		}
		return result*myPow(x, n-(int)temp);
    }
	
	double myPow2(double x, int n) {
	    if(n<0) return 1/x * myPow(1/x, -(n+1));
	    if(n==0) return 1;
	    if(n==2) return x*x;
	    if(n%2==0) return myPow( myPow(x, n/2), 2);
	    else return x*myPow( myPow(x, n/2), 2);
	}
	public static void main(String[] args){
		Pow_50 p = new Pow_50();
		System.out.println(p.myPow(34.00515, -3));
		System.out.println(Math.pow(34.00515, -3));
	}
}
