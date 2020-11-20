package graph;

import java.util.LinkedList;
import java.util.Stack;

// TS is only possible for directed acyclic graph
// from 0 indegree to 0 outdegree
// TC:(O(V+E)
// SC: O(V)    for stack
// topological sorting is mainly used for scheduling jobs from the given dependencies among jobs (more on gfg) 
// Questions: COURSE SCHEDULE 2
// Given courses with their prerequisite courses find the order of taking the course to cover all courses

public class TopologicalSort {
	
	static Stack<Integer> st = new Stack<>();
	
	static void sort(Graph g)
	{
		int v = g.v;
		LinkedList adj[] = g.adj;
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
		{
			dfs(v, adj, i, visited);
		}
		
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	
	static void dfs(int v, LinkedList<Integer>[] adj, int s, boolean []visited)
	{
		if(visited[s] == true)
			return;
		
		visited[s] = true;
		
		for(int i=0;i<adj[s].size();i++)
		{
			dfs(v, adj, adj[s].get(i), visited);
		}
		
		st.push(s);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Graph g = new Graph(6);
////		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(0, 3);
//		g.addEdge(3, 1);
//		g.addEdge(4, 1);
//		g.addEdge(4, 2);
//		g.addEdge(5, 0);
//		g.addEdge(5, 2);
		
		Graph g = new Graph(6);
//		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
//		g.addEdge(4, 2);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		
		sort(g);

	}

}
