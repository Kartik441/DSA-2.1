package dynamicProgramming;

public class TotalWaysCoinChangeProblem {
	// same code as count subsets for given sum with one change of unbounded knapsack
	// same code can be used for count number of ways to reach a given score in game
	static int totalWays(int []coin, int sum)
	{
		int n = coin.length;
		int t[][] = new int [n+1][sum+1];
		//Initialization
		
		for(int j =0; j<sum+1;j++)
		{
			t[0][j] = 0;
		}
		for(int i =0; i<n+1;i++)
		{
			t[i][0] = 1;
		}
		
		for(int i=1; i<n+1 ;i++)
		{
			for(int j=1; j<sum+1;j++)
			{
				
				if(coin[i-1] > j)
				{
					t[i][j] = t[i-1][j];
				}
				else
				{
					t[i][j] = t[i-1][j] + t[i][j - coin[i-1]];
				}
			}
		}
		
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		int coin[] = {1, 2, 3, 4};
		int sum = 5;
		
		System.out.println(totalWays(coin, sum));
		
		int point[] = {3, 5, 10};
		System.out.println(totalWays(point, 20));
		System.out.println(totalWays(point, 13));

	}

}
