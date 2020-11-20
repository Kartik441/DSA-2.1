package dynamicProgramming;

public class MinimumCostToFillBag {
// variation of rod cutting problem
// instead of min we need max
	static void solve(int cost[])
	{
		int n = cost.length;	
		int dp[] = new int [n+1];
		dp[0] =0;
		for(int i=1; i<n+1 ;i++)
		{
			int min_cost = Integer.MAX_VALUE;
			for(int j=0;j<i;j++)
			{
				min_cost = Math.min(min_cost, cost[j] + dp[i-j-1]);
			}
			dp[i] = min_cost;
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		int cost[] = {20, 10, 4, 50, 100};
		solve(cost);

	}

}
