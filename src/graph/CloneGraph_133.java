package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * 
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
public class CloneGraph_133 {
	Map<Integer, UndirectedGraphNode> oldNodes = new HashMap<Integer, UndirectedGraphNode>();
	Map<Integer, UndirectedGraphNode> newNodes = new HashMap<Integer, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
		UndirectedGraphNode u = dfs(node);
		return u;
    }
	
	public UndirectedGraphNode dfs(UndirectedGraphNode node){
		if(node==null) return null;
		UndirectedGraphNode un = new UndirectedGraphNode(node.label);
		for(int i = 0 ; i<node.neighbors.size() ; i++){
			UndirectedGraphNode temp = node.neighbors.get(i);
			if(temp==node){
				un.neighbors.add(un);
			}else if(oldNodes.containsKey(temp.label)){
				un.neighbors.add(newNodes.get(temp.label));
			}else{
				un.neighbors.add(dfs(temp));
			}
		}
		oldNodes.put(node.label, node);
		newNodes.put(un.label, un);
		return un;
	}
	
	public UndirectedGraphNode dfs2(UndirectedGraphNode node){
		if(node==null) return null;
		if(newNodes.containsKey(node.label)) return newNodes.get(node.label);
		UndirectedGraphNode un = new UndirectedGraphNode(node.label);
		newNodes.put(node.label, un);
		for(int i = 0 ; i<node.neighbors.size() ; i++){
			UndirectedGraphNode temp = node.neighbors.get(i);
			if(newNodes.containsKey(temp.label)){
				un.neighbors.add(newNodes.get(temp.label));
			}else{
				un.neighbors.add(dfs(temp));
			}
		}
		return un;
	}
	
}
