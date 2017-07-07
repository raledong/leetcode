package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rale
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * 	[
 * 	".Q..",  // Solution 1
 * 	"...Q",
 * 	"Q...",
 * 	"..Q."
 * 	],
 * 	[
 * 	"..Q.",  // Solution 2
 * 	"Q...",
 * 	"...Q",
 *  ".Q.."
 * 	]
 * ]
 */
public class NQueens_51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
        if(n==0){
        	return result;
        }
        //记录左右对角线情况
        Set<Integer> leftCordinal = new HashSet<Integer>(), rightCordinal = new HashSet<Integer>();
        Map<Integer, Integer> current = new HashMap<Integer, Integer>();
        solveNQueens(result, current, leftCordinal, rightCordinal, n);
        return result;
    }
	
	public void solveNQueens(List<List<String>> result, Map<Integer, Integer> current, Set<Integer> leftCordinal, Set<Integer> rightCordinal, int n){
		if(current.size() == n){
			List<String> currentResult = new ArrayList<String>();
			StringBuilder s = new StringBuilder();
			for(int i = 0 ; i<n ; i++){
				s.append(".");
			}
			for(int i = 0; i<n ; i++){
				s.setCharAt(current.get(i), 'Q');
				currentResult.add(s.toString());
				s.setCharAt(current.get(i), '.');
			}
			result.add(currentResult);
			return;
		}
		int row = current.size();
		if(row == 0){
			for(int i = 0 ; i<n ; i++){
				current.put(row, i);
				leftCordinal.add(row+i);
				rightCordinal.add(i-row);
				solveNQueens(result, current, leftCordinal, rightCordinal, n);
				leftCordinal.remove(row+i);
				rightCordinal.remove(i-row);
			}
		}else{
			for(int i = 0 ; i<n ; i++){
				if(current.containsValue(i) || leftCordinal.contains(row+i) || rightCordinal.contains(i-row)){
					continue;
				}
				current.put(row, i);
				leftCordinal.add(row+i);
				rightCordinal.add(i-row);
				solveNQueens(result, current, leftCordinal, rightCordinal, n);
				leftCordinal.remove(row+i);
				rightCordinal.remove(i-row);
			}
		}
		current.remove(row);
	}
	
	public List<List<String>> solveNQueens2(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
        if(n==0){
        	return result;
        }
        //记录左右对角线情况
        boolean[] leftCordinal = new boolean[n*2-1], rightCordinal = new boolean[n*2-1];
        Map<Integer, Integer> current = new HashMap<Integer, Integer>();
        solveNQueens2(result, current, leftCordinal, rightCordinal, n);
        return result;
    }
	
	public void solveNQueens2(List<List<String>> result, Map<Integer, Integer> current, boolean[] leftCordinal, boolean[] rightCordinal, int n){
		if(current.size() == n){
			List<String> currentResult = new ArrayList<String>();
			StringBuilder s = new StringBuilder();
			for(int i = 0 ; i<n ; i++){
				s.append(".");
			}
			for(int i = 0; i<n ; i++){
				s.setCharAt(current.get(i), 'Q');
				currentResult.add(s.toString());
				s.setCharAt(current.get(i), '.');
			}
			result.add(currentResult);
			return;
		}
		int row = current.size();
		for(int column = 0 ; column<n ; column++){
			if(current.containsValue(column) || leftCordinal[row+column] || rightCordinal[column-row+n-1]){
				continue;
			}
			current.put(row, column);
			leftCordinal[row+column] = true;
			rightCordinal[column-row+n-1] = true;
			solveNQueens2(result, current, leftCordinal, rightCordinal, n);
			leftCordinal[row+column] = false;
			rightCordinal[column-row+n-1] = false;;
		}
		current.remove(row);
	}
	
	
	//将map数据结构int[]+boolean[]+lines[]+
	List<List<String>> res;
    boolean[] col, lslash, rslash;
    int[] p;
    int n;
    String[] lines;
    private void dfs(int i) {
        if(i == n) {
            List<String> board = new ArrayList<String>();
            for(int j = 0; j < n; j++) {
                board.add(lines[p[j]]);
            }
            res.add(board);
            return;
        }
        
        for(int j = 0; j < n; j++) {
            if(!col[j] && !lslash[i+j] && !rslash[j-i+n-1]) {
                col[j] = true;
                lslash[i+j] = true;
                rslash[j-i+n-1] = true;
                p[i] = j;
                dfs(i+1);
                col[j] = false;
                lslash[i+j] = false;
                rslash[j-i+n-1] = false;
            }
        }
    }
    public List<List<String>> solveNQueens3(int n) {
        this.n = n;
        res = new ArrayList<List<String>>();
        col = new boolean[n];
        lslash = new boolean[2*n-1];
        rslash = new boolean[2*n-1];
        p = new int[n];
        char[] line = new char[n];
        lines = new String[n];
        for(int i = 0; i < n; i++) {
            line[i] = '.';
        }
        for(int i = 0; i < n; i++) {
            line[i] = 'Q';
            lines[i] = String.copyValueOf(line);
            line[i] = '.';
        }
        dfs(0);
        return res;
    }
	public static void main(String[] arg){
		NQueens_51 n = new NQueens_51();
		System.out.println(n.solveNQueens2(4).size());
	}
	
	
}
