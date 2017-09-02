package other;

/**
 * @author rale
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame_174 {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        int row = dungeon.length;
        int column = dungeon[0].length;
        dungeon[row-1][column-1] = dungeon[row-1][column-1]>=0 ? 1 : -dungeon[row-1][column-1]+1; 
        for(int i = row-2 ; i>=0 ; i--){
        	dungeon[i][column-1] = dungeon[i+1][column-1]-dungeon[i][column-1];
        	dungeon[i][column-1] = dungeon[i][column-1]>0 ? dungeon[i][column-1] : 1;
        }
        
        for(int j = column-2 ; j>=0 ; j--){
        	dungeon[row-1][j] = dungeon[row-1][j+1]-dungeon[row-1][j];
        	dungeon[row-1][j] = dungeon[row-1][j]>0 ? dungeon[row-1][j] : 1;
        }

        for(int i = row-2 ; i>=0 ; i--){
        	for(int j = column-2 ; j>=0 ; j--){
        		dungeon[i][j] = Math.min(dungeon[i][j+1], dungeon[i+1][j]) - dungeon[i][j];
        		dungeon[i][j] = dungeon[i][j] > 0 ? dungeon[i][j] : 1;
        	}
        }
        return dungeon[0][0];
        
    }
	
	public static void main(String[] args){
		DungeonGame_174 d = new DungeonGame_174();
		d.calculateMinimumHP(new int[][]{
			{1,-3,3},{0,-2,0},{-3,-3,-3}
		});
	}
}
