package dynamicProgramming;
//count ways to reach the nth stair
//if the person can climb only 1 or 2 stairs at a time
// breakdown reached to a simple fibonnaci problem

public class StaircaseProblem{
	
	// returns no of ways to reach stairs recursively
	// O(2^n)
	
//	static int rec(int s, int m)
//	{
//		return countWaysUtil(s+1, m);
//	}
//	
//	static int countWaysUtil(int n, int m)
//	{
//		if(n <= 0)
//			return 0;
//		if(n == 1)
//			return n;
//		
//		int res = 0;
//		for(int i=1;i<=m;i++)
//		{
//			res += countWaysUtil(n-i, m);
//		}
//		return res;
//	}
	
	
	// Using dp
	// TC: O(mn)
	// SC:O(n)
	
//	static int countWays(int s, int m)
//	{
//		return countWaysUtil(s+1, m);
//	}
//	
//	static int countWaysUtil(int n, int m)
//	{
//		int res[] = new int[n];
//		res[0] = 1;
//		res[1] = 1;
//		
//		for(int i=2; i<n;i++)
//		{
//			res[i]  = 0;
//			for(int j = 1; j<=m && j<=i;j++)
//			{
//				res[i] += res[i-j];
//			}
//		}
//		return res[n-1];
//	}
	
	
	// Now we optimize dp solution by using a sliding window protocol
	// TC:O(n)
    // SC:O(n)	
	static int countWays(int n, int m)
	{
		int res[] = new int[n+1];
		int temp = 0;
		res[0] = 1;
		
		for(int i=1;i<=n;i++)
		{
			int start = i - m - 1;
			int e = i - 1;
			if(start >= 0)
			{
				temp -= res[start];
			}
			temp += res[e];
			res[i] = temp;
		}
		return res[n];
	}

	public static void main(String[] args) {
		int s = 5;
		int m = 3;     // means at most m stairs can be climbed at once
		System.out.println(countWays(s,m));
//		System.out.println(rec(s,m));

	}

}
