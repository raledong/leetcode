package math;

/**
 * @author rale
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
public class Sqrt_69 {
	
	//最简单 但是效率低下
	public int mySqrt(int x) {
		int i = 0;
		int currentResult = 0;
		while((currentResult=i*i) < x && currentResult>0){
			i++;
		}
		if(currentResult == x){
			return i;
		}
		return i-1;	
    }
	
	//正宗二分法
	public int mySqrt2(int x){
		if(x==0){
			return 0;
		}
		int left = 0;
		int right = Integer.MAX_VALUE;
		while(true){
			int mid = ( left + right ) / 2;
			System.out.println(mid);
			if(mid > x / mid){
				right = mid - 1;
			}else{
				if((mid + 1)  > x / (mid + 1)){
					return mid;
				}
				left = mid + 1;
			}
		}
	}
	
	//同样二分法 使用了long解决越界情况
	public int mySqrt3(int x){
		long start = 1, end = x;
        
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        
        return (int) start;
	}
	
	public static void main(String[] args){
		Sqrt_69 s = new Sqrt_69();
		System.out.println(s.mySqrt2(5));
	}
}
