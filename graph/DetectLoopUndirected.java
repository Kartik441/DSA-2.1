package graph;

import java.util.LinkedList;

public class DetectLoopUndirected {
	
	static boolean cycle(Graph g)
	{
		int v = g.v;
		LinkedList<Integer>[] adj= g.adj; 
		
		for(int i=0;i<v;i++)
		{
			int visited[] = new int[v];
			if(dfs(v, adj, i, visited) == true)
				return true;
		}
		return false;
	}
	
	static boolean dfs(int v, LinkedList<Integer> []adj, int s, int visited[])
	{
		for(int n:visited)
		{
			System.out.print(n+" ");
		}
		System.out.println("s "+s);
		if(visited[s] == 2)
		{
			System.out.println(s + "Dhar liyaa");
			return true;
		}
		
		visited[s]++;
		
		for(int i=0;i<adj[s].size(); i++)
		{
			int n = adj[s].get(i);
			
			if(dfs(v, adj, n, visited) == true)
				return true;
			
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
//		g.addEdge(0, 3);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
//		g.addEdge(3, 0);
		g.addEdge(3, 2);
		
		System.out.println(cycle(g));

	}

}
