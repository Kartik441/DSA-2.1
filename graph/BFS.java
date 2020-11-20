package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	
	static void bfs(Graph g,int s)      // s indicates start point
	{
		int v = g.v;
		LinkedList adj[] = g.adj;
		boolean visited[] = new boolean[v];
		
		//  create a queue
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		visited[s] = true;
		q.add(s);
		
		while(q.size()!=0)
		{
			s = q.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		bfs(g, 2);

	}

}
