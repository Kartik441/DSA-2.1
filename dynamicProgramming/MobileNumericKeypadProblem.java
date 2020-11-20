package dynamicProgramming;

public class MobileNumericKeypadProblem {
	
	static void solve(int n)
	{
		int [][]dp = new int[n+1][10];
		int [][]data = {
				{0, 8},
				{1, 2, 4},
				{1, 2, 3, 5},
				{2, 3, 6},
				{1, 4, 5, 7},
				{2, 4, 5, 6, 8},
				{3, 5, 6, 9},
				{4, 7, 8},
				{5, 7, 8, 9, 0},
				{6, 8, 9}
		};

		
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<=9;j++)
			{
				if(i == 1)
					dp[i][j] = 1;
				else
				{
					for(int prev:data[j])
						dp[i][j] += dp[i-1][prev];
				}
			}
		}
		int sum =0;
		for(int j=0;j<=9;j++)
		{
			sum += dp[n][j];
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		for(int i=1;i<=5;i++)
		{
			solve(i);
		}
		

	}

}
