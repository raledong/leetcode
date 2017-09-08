package other;

/**
 * @author rale
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumberofIslands_200 {
	
	/**
	 * union find 思路
	 */
	int row;
	int column;
	char[][] grid;
	int count;
	int[][] tempRegion;
	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0){
			return 0;
		}
        
		this.grid = grid;
		this.row = grid.length;
		this.column = grid[0].length;
		this.count = row * column; 
        this.tempRegion = new int[row][column];

		for(int i = 0 ; i<row ; i++){
			for(int j = 0 ; j<column ; j++ ){
				if(grid[i][j]=='0'){ 
					this.count--;
				}else{
					tempRegion[i][j] = i * column + j;
					if(i==0 && j==0){
						continue;
					}else if(i==0){
						tempRegion[i][j] = j;
						if(grid[i][j-1]!='0') union(j-1, j);
					}else if(j==0){
						tempRegion[i][j] = i*column;
						if(grid[i-1][j]!='0') union((i-1)*column, i*column);
					}else{
						tempRegion[i][j] = i*column+j;
						if(grid[i-1][j]!='0') union((i-1)*column+j, i*column+j);
						if(grid[i][j-1]!='0') union(i*column+j-1, i*column+j);
					}
				}
			}
		}
		return count;
    }
	
	private void union(int index1, int index2){
		int r1 = find(index1);
		int r2 = find(index2);
		if(r1==r2) return;
		tempRegion[r2/column][r2%column] = r1 ;
		count--;
	}
	
	private int find(int index){
		while(tempRegion[index/column][index%column] != index) index = tempRegion[index/column][index%column]; 
		return index;
	}
	
	/**
	 * dfs
	 * @param grid
	 * @return
	 */
	public int numIslands2(char[][] grid){
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		this.row = grid.length;
		this.column = grid[0].length;
		int count = 0;
		for(int i = 0 ; i<row ; i++){
			for(int j = 0 ; j<column ; j++){
				if(grid[i][j]=='1'){
					count++;
					merge(grid, i, j);
				}
			}
		}
		return count;
	}
	
	public void merge(char[][] grid, int i , int j){
		if(i<0 || i>row || j<0 || j>column || grid[i][j] != '1') return;
		grid[i][j] = 'X';
		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j-1);
		merge(grid, i, j+1);
	}
	public static void main(String[] args){
		NumberofIslands_200 n = new NumberofIslands_200();
//		n.numIslands(new char[][]{
//			"11110".toCharArray(),"11010".toCharArray(),"11000".toCharArray(),"00000".toCharArray()
//		});
		n.numIslands(new char[][]{
			"1111111".toCharArray(),
			"0000001".toCharArray(),
			"1111101".toCharArray(),
			"1000101".toCharArray(),
			"1010101".toCharArray(),
			"1011101".toCharArray(),
			"1111111".toCharArray()
		});
	}
}
