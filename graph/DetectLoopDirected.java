package graph;

import java.util.LinkedList;

// Using dfs approach
// TC: O(V+E)
// SC: O(V)

public class DetectLoopDirected {
	
	static boolean cycle(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		
		for(int i=0;i<v;i++)
		{
			boolean visited[] = new boolean[v];
			if(dfs(v, adj, i, visited) == true)
				return true;
			else
				visited[i] = false;
		}
		return false;
	}
	
	static boolean dfs(int v, LinkedList<Integer>[] adj, int s, boolean visited[])
	{
		if(visited[s] == true)
			return true;
		
		visited[s] = true;
		for(int i=0; i<adj[s].size();i++)
		{
			int n = adj[s].get(i);
			
			if(visited[n] == true)     // I think we can remove this lines
				return true;
			else
				{
					if(dfs(v, adj, n, visited) == true)
						return true;
					else
						visited[n] = false;
				}
		}
		
		return false;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Graph g = new Graph(5);
//		g.addEdge(0, 1);
//		g.addEdge(2, 3);
//		g.addEdge(2, 1);
//		g.addEdge(3, 4);
//		g.addEdge(4, 0);
//		g.addEdge(4, 2);
		
//		Graph g = new Graph(4);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 0);
//		g.addEdge(2, 3);
//		g.addEdge(3, 3);
		
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
	
		
		System.out.println(cycle(g));

	}

}
