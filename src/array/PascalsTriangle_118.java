package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class PascalsTriangle_118 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0 ; i<numRows ; i++){
        	List<Integer> temp = new ArrayList<Integer>();
        	for(int j = 0 ; j<=i ; j++){
        		if(j==0 || j==i){
            		temp.add(1);
            	}else{
            		temp.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));	
            	}
            }
        	result.add(temp);
        }
        return result;
    }
	
	public static void main(String[] args){
		PascalsTriangle_118 p = new PascalsTriangle_118();
		p.generate(3);
	}
}
