package graph;

public class NumberOfIslands {
	// TC: we are visiting each element at most 5 times (1 while visiting and 4 other ways)
	//   : O(5mn) => o(mn)
	static int islands = 0;
	
	static void totalIslands(int grid[][])
	{
		int n = grid.length;
		int m = grid[0].length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j] == 1)
				{
					solve(grid, i, j);
					islands++;
				}
				
			}
		}
	}
	
	static void solve(int grid[][], int i, int j)
	{
		if( i < 0 || j < 0 || i>= grid.length || j>=grid[0].length)
			return;
		
		if(grid[i][j] == 0)
			return;
		
		if(grid[i][j] == 2)
			return;
		
		if(grid[i][j] == 1)
		{
			grid[i][j] = 2;
			solve(grid, i+1, j);
			solve(grid, i-1, j);
			solve(grid, i, j+1);
			solve(grid, i, j-1);
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
				{1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}
				
		};
		totalIslands(grid);
		System.out.println(islands);
		islands = 0;
		
		
		int grid1[][] = {
				{1, 1, 1, 1},
				{1, 0, 0, 1},
				{1, 0, 0, 0},
				
		};
		totalIslands(grid1);
		System.out.println(islands);
		islands = 0;
		
		
		int grid2[][] = {
				{1, 1, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0},
				
				
		};
		totalIslands(grid2);
		System.out.println(islands);

	}

}
