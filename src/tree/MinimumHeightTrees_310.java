package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Example 1 :
 * 
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * @author rale
 *
 */
public class MinimumHeightTrees_310 {
	
	/**
	 * 效率极其低下 每一轮都删除掉叶节点 最终剩余的1个或2个叶节点就是所求的根节点
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n==1) return Collections.singletonList(0);
		//初始化邻接表
		List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
		for(int i = 0 ; i<n ; i++) {
			adj.add(new HashSet<Integer>());
		}
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		
		List<Integer> leaves = new ArrayList<Integer>();
		for(int i = 0 ; i<adj.size() ; i++) {
			if(adj.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		while(n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);
	            if (adj.get(j).size() == 1) newLeaves.add(j);
	        }
			leaves = newLeaves;
		}
		return leaves;
    }
	
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
		if(n==1) return Collections.singletonList(0);
		int[] connected = new int[n];
		int[] degree = new int[n];
		
		for(int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];
			connected[v1] ^= v2;
			connected[v2] ^= v1;
			
			degree[v1]++;
			degree[v2]++;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i = 0 ; i<degree.length ; i++) {
			if(degree[i] == 1) {
				queue.offer(i);
			}
		}
		
		while(n > 2 && !queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0 ; i<size ; i++) {
				int v = queue.poll();
				n--;
				int v1 = connected[v];
				connected[v1] ^= v;
				degree[v1]--;
				if(degree[v1] == 1) {
					queue.add(v1);
				}
			}	
		}
		
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(queue);
		return result;
	}
}
