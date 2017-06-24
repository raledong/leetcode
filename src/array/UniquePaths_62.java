package array;

/**
 * @author rale
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class UniquePaths_62 {

	public int uniquePaths(int m, int n) {
        return uniquePaths(1,1,m, n);
    }
	
	public int uniquePaths(int currentRow, int currentColumn, int m, int n){
		if(currentRow==m || currentColumn==n){
			return 1;
		}	
		return uniquePaths(currentRow+1, currentColumn, m ,n ) + uniquePaths(currentRow, currentColumn+1, m, n);
	}
	//方法1和方法2的性质相同 都是利用递归的方式来计算，但是效率低 都超时了
	public int uniquePaths2(int m, int n){
		if(m==1 || n==1){
			return 1;
		}
		return uniquePaths2(n-1, m) + uniquePaths2(n, m-1);
	}
	
	//数学方法 排列组合
	public int uniquePaths3(int m, int n){
		int totalPath = m + n - 2;
		int down = m-1;
		int right = n-1;
		if(down == 0 || right==0){
			return 1;
		}
		int count = Math.min(down, right);
		long result = 1;
		for(int i = 1 ; i<=count ; i++){
			result *= totalPath--;
			result /= i;
		}
		return (int) result;
	}
	
	//杨辉三角的运用啦
	public int uniquePath4(int m, int n){
		int[][] map = new int[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
	}
	public static void main(String[] args){
		UniquePaths_62 u = new UniquePaths_62();
		System.out.println(System.currentTimeMillis());
		System.out.println(u.uniquePaths(23, 12));
		System.out.println(System.currentTimeMillis());
		System.out.println(u.uniquePaths2(23, 12));
		System.out.println(System.currentTimeMillis());
		System.out.println(u.uniquePaths3(23, 12));
		System.out.println(System.currentTimeMillis());
	}
}
