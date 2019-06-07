package dynamicprogramming;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK_363 {
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		if(row == 0) return 0;
		int col = matrix[0].length;
		if(col == 0) return 0;
		
		//rectangle[i][j]记录顶点为[0,0],[i,j]的矩形的面积
        int[][] rectangle = new int[row][col];
        for(int i = 0 ; i<row ;  i++) {
        	for(int j = 0 ; j<col ; j++) {
        		int area = matrix[i][j];
        		if(i>0) {
        			area += rectangle[i-1][j];
        		}
        		if(j>0) {
        			area += rectangle[i][j-1];
        		}
        		//减去重复计算的面积
        		if(i>0 && j>0) {
        			area -= rectangle[i-1][j-1];
        		}
        		
        		rectangle[i][j] = area;
        	}
        }
        
        
        int result = Integer.MIN_VALUE;
        for(int startRow = 0 ; startRow<row; startRow++) {//矩形的起点行
        	for(int endRow = startRow ; endRow<row ; endRow++) {//矩形的结束行
        		for(int startCol = 0 ; startCol<col ; startCol++) {//矩形的起始列
        			for(int endCol = startCol ; endCol<col ; endCol++) {//矩形的结束列
        				int area = rectangle[endRow][endCol];
        				if(startRow > 0) {
        					area -= rectangle[startRow-1][endCol];
        				}
        				if(startCol > 0) {
        					area -= rectangle[endRow][startCol-1];
        				}
        				if(startRow > 0 && startCol > 0) {
        					area += rectangle[startRow-1][startCol-1];
        				}
        				if (area <= k)
        					result = Math.max(result, area);
        			}
        		}
        	}
        }
        return result;
    }
	
	public int maxSumSubmatrix2(int[][] matrix, int k) {
		int row = matrix.length;
		if(row == 0) return 0;
		int col = matrix[0].length;
		if(col == 0) return 0;
		
		//rectangle[i][j]记录顶点为[0,0],[i,j]的矩形的面积
        int[][] rectangle = new int[row][col];
        for(int i = 0 ; i<row ;  i++) {
        	for(int j = 0 ; j<col ; j++) {
        		int area = matrix[i][j];
        		if(i>0) {
        			area += rectangle[i-1][j];
        		}
        		if(j>0) {
        			area += rectangle[i][j-1];
        		}
        		//减去重复计算的面积
        		if(i>0 && j>0) {
        			area -= rectangle[i-1][j-1];
        		}
        		
        		rectangle[i][j] = area;
        	}
        }
        
        
        int result = Integer.MIN_VALUE;
        for(int startRow = 0 ; startRow < row ; startRow++) {
        	for(int endRow = startRow ; endRow < row ; endRow++) {
        		//记录从startRow到endRow之间所有以最左侧边为起点的矩形的面积
        		TreeSet<Integer> treeSet = new TreeSet<Integer>();
        		treeSet.add(0);
        		for(int endCol = 0 ; endCol < col ; endCol++) {
        			int area = rectangle[endRow][endCol];
        			if(startRow > 0) {
        				area -= rectangle[startRow-1][endCol];
        			}
        			//可以减去的左侧矩形的最小面积
        			Integer remain = treeSet.ceiling(area - k);
        			if(remain != null) {
            			result = Math.max(result, area - remain);
        			}
        			treeSet.add(area);
        		}
        	}
        }
        return result;
	}
	
	public int maxSumSubmatrix3(int[][] matrix, int k) {
		int row = matrix.length;
		if(row == 0) return 0;
		int col = matrix[0].length;
		if(col == 0) return 0;
		int result = Integer.MIN_VALUE;
		int[] sums = new int[row+1];//sums[i]记录startCol到endCol列之间，0行到i行构成的矩阵的面积
		for(int startCol = 0 ; startCol<col ; startCol++) {
			int[] sumInRow = new int[row];//sumInRow[i]记录startCol到endCol列之间第i行所有元素的和
			for(int endCol = startCol; endCol<col ; endCol++) {
				for(int endRow = 0 ; endRow<row ; endRow++) {
					sumInRow[endRow] += matrix[endRow][endCol];
					sums[endRow+1] = sums[endRow] + sumInRow[endRow];
				}
				//对startCol到endCol列之间所有的矩阵元素和构成的数组通过分治法找到最大的连续子数组
				result = Math.max(result, mergeSort(sums, k, 0, sums.length));
				if(result == k) return k;
			}
		}
		return result;
	}
	
	public int mergeSort(int[] sums, int k, int start, int end) {
		//矩阵数组至少包含一个元素
		if(end <= start + 1) return Integer.MIN_VALUE;
		int mid = start + (end - start)/2, cacheIndex = 0;
		//对左侧递归计算，此时sums数组[start,mid)之间的元素已经有序
		int ans = mergeSort(sums, k,  start, mid);
		if(ans == k) return k;
		//对右侧递归计算，此时sums数组[mid,end)之间的元素已经有序
		ans = Math.max(ans, mergeSort(sums, k, mid, end));
		//缓存sums数组[start,end)之间排序的结果
		int[] sortedSubSums = new int[end - start];
		if(ans == k) return k;
		for(int i = start, j = mid, m = mid ; i<mid ;  i++) {
			while(j<end && sums[j] - sums[i] <= k) j++;//找到第一个满足[i,j)之间的元素和大于k，[i,j-1)之间的元素和小于等于k的连续子数组
			if(j > mid) {
				ans = Math.max(sums[j-1] - sums[i], ans);
				if (ans == k) return k;
			}
			while(m<end && sums[m] < sums[i]) sortedSubSums[cacheIndex++] = sums[m++];//排序，通过每次将中间位置右侧比左侧当前位置小的元素全部复制有序数组缓存中
			sortedSubSums[cacheIndex++] = sums[i];
		}
		System.arraycopy(sortedSubSums, 0, sums, start, cacheIndex);
		return ans;
	}
	public static void main(String[] args) {
		MaxSumofRectangleNoLargerThanK_363 m = new MaxSumofRectangleNoLargerThanK_363();
		m.maxSumSubmatrix3(new int[][]{
			{2, 2, -1}
		}, 0);
	}
	
}
