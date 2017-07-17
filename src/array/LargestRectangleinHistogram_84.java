package array;

import java.util.LinkedList;

/**
 * @author rale
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleinHistogram_84 {

	//超时啊==
	public int largestRectangleArea(int[] heights) {
        int barCount = heights.length;
        
        int max = 0;
        for(int i = 0 ; i<barCount ; i++){
        	int tempHeight = heights[i];
        	int tempWidth = 1;
        	for(int j = i-1 ; j>=0 && heights[j]>=tempHeight ; j--) tempWidth++;
        	for(int j = i+1 ; j<barCount && heights[j]>=tempHeight ; j++) tempWidth++;
        	max = Math.max(max, tempWidth*tempHeight);
        }
        return max;
    }
	
	//stack
	public int largestRectangleArea2(int[] heights){
		int barCount = heights.length;
		int max = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(int i = 0 ; i<barCount ; i++){
			int tempHeight = heights[i];
			int lastIndex = i;
			while(!stack.isEmpty() && heights[stack.peek()]>tempHeight){
				lastIndex = stack.pop();
				max = Math.max(max, (i-lastIndex)*heights[lastIndex]);
				heights[lastIndex] =tempHeight; 
			}
			stack.push(lastIndex);
		}
		while(!stack.isEmpty()){
			int currentIndex = stack.pop();
			max = Math.max(max, (barCount-currentIndex)*heights[currentIndex]);
		}
		return max;
	}
	
	//left & right 
	public int largestRectangleArea3(int[] heights){
		int barCount = heights.length;
		if(barCount==0) return 0;
		int[] lessThanLeft = new int[barCount];
		int[] lessThanRight = new int[barCount];
		lessThanLeft[0] = -1;
		lessThanRight[barCount-1] = barCount;
		for(int i = 1 ; i<barCount ; i++){
			int p = i-1;
			while(p>=0 && heights[p]>=heights[i]){
				p = lessThanLeft[p];
			}
			lessThanLeft[i] = p;
		}
		for(int i = barCount-2 ; i>=0 ; i--){
			int p = i+1;
			while(p<barCount && heights[p]>=heights[i]) p = lessThanRight[p];
			lessThanRight[i] = p;
		}
		
		int max = 0;
		for(int i = 0 ; i<barCount ; i++){
			max = Math.max(max, heights[i]*(lessThanRight[i]-lessThanLeft[i]-1));
		}
		return max;
	}
	
	public static void main(String[] args){
		LargestRectangleinHistogram_84 l = new LargestRectangleinHistogram_84();
		l.largestRectangleArea2(new int[]{2,1,2});
	}
	
}
