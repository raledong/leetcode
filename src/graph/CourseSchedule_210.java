package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
 * So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
 * Both courses 1 and 2 should be taken after you finished course 0.
 *  So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseSchedule_210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inputDegree = new int[numCourses];
        for(int i = 0 ; i<prerequisites.length ; i++){
        	inputDegree[prerequisites[i][0]]++;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int next = 0;
        while((next = nextVertex(inputDegree)) != -1){
        	result.add(next);
        	inputDegree[next] = -1;
        	updateGraph(inputDegree, prerequisites, next);
        }
        if(result.size()!=numCourses) return new int[0];
        int[] array = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++){
        	array[i] = result.get(i);
        }
        return array;
        
    }
	
	public int nextVertex(int[] inputDegree){
		for(int i = 0 ; i<inputDegree.length ; i++){
			if(inputDegree[i]==0) return i;
		}
		return -1;
	}
	
	public void updateGraph(int[] inputDegree, int[][] prerequisites, int vertex){
		for(int i = 0 ; i<prerequisites.length ; i++){
			if(prerequisites[i][1]==vertex) inputDegree[prerequisites[i][0]]--;
		}
	}
	
	public static void main(String[] args){
		CourseSchedule_210  c = new CourseSchedule_210();
		c.findOrder(2, new int[][]{
			{1,0},
			{0,1}
		});
	}
}
