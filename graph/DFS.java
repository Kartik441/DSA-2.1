package graph;

import java.util.Iterator;
import java.util.LinkedList;
// Time Complexity: O(V+E)
// Space Complexity: O(V)

public class DFS {
	// This will not handle disconnected graph
	static void dfs(Graph g, int s)
	{
		int v = g.v;
		LinkedList adj[] = g.adj;
		boolean visited[] = new boolean[v];
		dfsUtil(v, adj, s, visited );
	}
	
	static void dfsUtil(int v, LinkedList[] adj, int s, boolean visited[])
	{
		visited[s] = true;
		System.out.println(s+" ");
		
		Iterator<Integer> i =adj[s].iterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				dfsUtil(v, adj, n, visited);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		dfs(g, 2);

	}

}
