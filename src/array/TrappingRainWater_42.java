package array;

import java.util.Stack;

/**
 * @author rale
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater_42 {
	
	//使用堆栈，分别存储值和下标
	public int trap(int[] height) {
		int length = height.length;
		if(length<=0){
			return 0;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		s.push(0);
		index.push(1);
		
		int leftMost = 0;
		int result = 0;
		for(int i = 0 ; i<length ; i++){
			int currentVal = height[i];
			if(currentVal >= leftMost){
				while(!s.isEmpty()){
					result += (leftMost - s.pop()) * index.pop();
				}
				s.push(currentVal);
				index.push(1);
				leftMost = currentVal;
			}else{
				int count = 1;
				while(currentVal > s.peek()){
				    count += index.peek();
					result += (currentVal - s.pop()) * index.pop();
				}
				s.push(currentVal);
				index.push(count);
			}
		}
		return result;	
    }
	
	//优化堆栈
	public int trap2(int[] height){
		int length = height.length;
		int result = 0, current = 0;
		
		Stack<Integer> s = new Stack<Integer>();
		
		while(current < length){
			while(!s.isEmpty() && height[current] > height[s.peek()]){
				int top = s.pop();
				if(s.isEmpty()){
					break;
				}
				//获得两个节点之间的宽度
				int distance = current - s.peek() - 1;
				int tempHeight = Math.min(height[current], height[s.peek()]) - height[top];
				result += tempHeight  * distance;
			}
			s.push(current++);
		}
		return result;
	}
	//双指针 不使用堆栈
	public int trap3(int[] height) {
		int length = height.length;
		if(length<=2){
			return 0;
		}
		
		int startIndex = 0;
		while(startIndex<length-1 && height[startIndex]<=height[startIndex+1]){
			startIndex++;
		}
		
		int result = 0;
		
		int index = startIndex;
		while(++index < length){
			int currentHeight = height[index];
			if(currentHeight > height[startIndex]){
				for(int i = index-1 ; i > startIndex ; i--){
					result += (height[startIndex] - height[i]);
				}
				startIndex = index;
			}else{
				for(int i = index ; i>0 && height[i] > height[i-1] ; i--){
					result += (height[i] - height[i-1]);
					height[i-1] = height[i];
				}
			}
		}
		return result;
	}
	
	//双指针终极版
	public int trap4(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int result = 0;
		int leftMax=0, rightMax=0;
		while(left < right){
			if(height[left] < height[right]){
				leftMax = Math.max(height[left], leftMax);
				result += leftMax - height[left];
				left++;
			}else{
				rightMax = Math.max(height[right], rightMax);
				result += rightMax - height[right];
				right--;
			}
		}
		return result;
	}
	//分别得出从左往右和从右往左的各个下标上的最大值。二者的最小值即为该下标上可能的最大值。
	public int trap5(int[] height){
		int length = height.length;
		int[] left = new int[length];
		int[] right = new int[length];
		
		int leftMax = 0;
		int rightMax = 0;
		for(int i = 0 ; i<length ; i++){
			leftMax = left[i] = Math.max(leftMax,	height[i]);
			rightMax = right[length-i-1] = Math.max(rightMax, height[length-i-1]);
		}
		int result = 0;
		for(int j = 0 ; j<length ; j++){
			result += Math.min(left[j], right[j]) - height[j];
		}
		return result;
	}

	public static void main(String[] args){
		TrappingRainWater_42 t = new TrappingRainWater_42();
//		t.trap3(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3});
		t.trap3(new int[]{0,2,0});
	}
	
	
	
}
