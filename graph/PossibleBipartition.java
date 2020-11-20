package graph;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
	
	// a bipartite graph is a graph whose vertices can be divided into 2 disjoint and independent sets U and V such that
	// every edge connects a vertex U to a vertex V
	
	// A bipartite graph can only have even edge length cycle
	
	// odd cycle will only be possible if there is an edge between 2 vertices in a SET but than the graph will no longer be 
	// bipartite
	
	// if there is no odd length ((cycle)) than graph is bipartite
	// better way is to use graph coloring method by using only two colors to detect odd length cycle
	
	// we can use loop to check all components are colored in multi-component graph
	
	// TC : O(E + V)
	// E for making adjacency list and V for coloring
	
	
	static boolean possibleBipartite(int n, int [][] dislikes)
	{
		// creating undirected graph
		
		int v = n;
		LinkedList<Integer> adj[] = new LinkedList[n];
		
		for(int i=0; i<v;i++)
			adj[i] = new LinkedList();
		
		for(int i=0;i<dislikes.length;i++)
		{
			adj[dislikes[i][0]].add(dislikes[i][1]);
			adj[dislikes[i][1]].add(dislikes[i][0]);
		}
		// Using graph coloring
		// 0 for one color
		// 1 for second color
		int visited[] = new int[n]; 
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		//int curr = 0;
		int color = 0;
		visited[0] = color;
		while(!q.isEmpty())
		{
			int curr = q.poll();
			// visit this node and assign color
			color = visited[curr];
			int assignColor = 1 - color;
			
			// push adjacent elements in queue
			for(int i=0;i<adj[curr].size(); i++)
			{
				// push into queue
				if(visited[adj[curr].get(i)] == -1)
				{
					q.offer(adj[curr].get(i));
					visited[adj[curr].get(i)] = assignColor;
				}
				
				// if it is already colored
				// than check if there is any ambiguity
				if(visited[adj[curr].get(i)] != assignColor)
					return false;
					
							
			}
			
			
		}
		return true;
		
	}
	
	static void dfs(int v, int adj, int s, int visited[])
	{
		
	}
	
	static int longestSubarray(int a[])
	{
		int ans = 0;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=0;i<a.length -1 ;i++)
		{
			hs.add(a[i]);
			int j = i+1;
			while(j < a.length && Math.abs(a[i] - a[j]) <= 1)
			{
				if(!hs.contains(a[j]))
				{
					if(hs.size() == 2)
					{
						System.out.println("break "+ i + j);
						break;
					}
					
					else
					{
						System.out.println("else "+ i + j);
						hs.add(a[j]);
					}
				}
				j++;
			}
			System.out.println("baahar "+ i + j);
			ans = Math.max(ans, j-i);
			hs.clear();
		}
		return ans;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = {0, 1, 2, 1, 2, 3};
//		System.out.println(longestSubarray(a));
		
		int dislikes[][] = {
				{0, 1},
				{1, 2},
				{1, 3},
				{2, 4},
				{3, 4},
				
		};
		
		int di[][] = {
				{0, 1},
				{1, 3},
				{3, 4},
				{4, 2},
				{0, 2}
		};
		
		int dis[][] = {
				{0, 1},
				{1, 3},
				{3, 2},
				{0, 2},
		};
		
		System.out.println(possibleBipartite(5, dislikes));
		System.out.println(possibleBipartite(5, di));
		System.out.println(possibleBipartite(4, dis));

	}

}
