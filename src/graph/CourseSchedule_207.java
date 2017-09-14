package graph;

/**
 * @author rale
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule_207 {
	
	/**
	 * 拓扑排序思想
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inputDegree = new int[numCourses];
		for(int i = 0 ; i<prerequisites.length ; i++){
			inputDegree[prerequisites[i][1]]++;
		}
		boolean[] hasDeleted = new boolean[numCourses];
		int vertex = 0;
		while((vertex = nextVertext(inputDegree, hasDeleted)) != -1){
			inputDegree[vertex] = 0;
			hasDeleted[vertex] = true;
			updateGraph(inputDegree, prerequisites, vertex);
			numCourses--;
		}
		return numCourses==0;
    }
	
	public int nextVertext(int[] inputDegree, boolean[] hasDeleted){
		for(int i = 0 ; i<inputDegree.length ; i++){
			if(!hasDeleted[i] && inputDegree[i]==0) return i;
		}
		return -1;
	}
	
	public void updateGraph(int[] inputDegree, int[][] prerequisites, int vertex){
		for(int i = 0 ; i<prerequisites.length ; i++){
			if(prerequisites[i][0]==vertex) inputDegree[prerequisites[i][1]]--;
		}
	}
	
	/**
	 * 生成树思想
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		int[] parent = new int[numCourses];
		for(int i = 0 ; i<numCourses ; i++){
			parent[i] = i;
		}
		for(int i = 0 ; i<prerequisites.length ; i++){
			int pre = prerequisites[i][1];
			int cur = prerequisites[i][0];
			if(pre == cur) return false;
			parent[cur] = pre;
			while(parent[pre] != pre){
				if(parent[pre] == cur) return false;
				pre = parent[pre];
			}
		}
		return true;
	}
}
