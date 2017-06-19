package other;

/**
 * @author rale
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * 
 * 实质上是斐波那契数列
 */
public class ClimbingStairs {

	//递归	
	public int climbStairs(int n) {
        if(n<=1){
        	return 1;
        }
        if(n%2==0){
        	return (int) (Math.pow(climbStairs(n/2), 2)+Math.pow(climbStairs(n/2-1), 2));
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
	
	public int climbStairs2(int n){
		if(n<=1){
			return 1;
		}
		int countTwo = 1;
		int total = 1;
		while(countTwo*2<=n){
			long temp = 1;
			for(int i = n-countTwo, j = 1 ; j<=countTwo; i--,j++){
				temp = temp*i/j;
			}
			total += temp;
			countTwo++;
		}
		return total;
	}
	
	public static void main(String[] args){
		
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs2(44));
		System.out.println(c.climbStairs(44));
	}
}
