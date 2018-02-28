package other;

/**
 * @author rale
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy_135 {
	public int candy(int[] ratings) {
		int count = 1;
		int summitIndex = 0;
		int summitCandy = 1;
		int prevCandy = 1;
		for(int i = 1 ; i<ratings.length ; i++){
			if(ratings[i] > ratings[i-1]){
				prevCandy++;
				count += prevCandy;
				summitIndex = i;
				summitCandy = prevCandy;
			}else if(ratings[i] < ratings[i-1]){
				if(prevCandy == 1){
					count += (i - summitIndex) + (i-summitIndex >= summitCandy ? 1 : 0);
				}else{
					prevCandy = 1;
					count += prevCandy;
				}
			}else{
				prevCandy = 1;
				count += prevCandy;
				summitIndex = i;
				summitCandy = prevCandy;
			}
		}
		return count;
    }
}
