package dynamicProgramming;

public class UnboundedKnapsack {
	
	//static int t[][] = new int [200+1][500+1];
// this can be optimized in terms of space	
	static int UKnapsack(int[] weight, int[] value, int w)
	{
		int n = weight.length;	
		int t[][] = new int [n+1][w+1];
		for(int i=0; i<n+1 ;i++)
		{
			for(int j=0; j<w+1;j++)
			{
				if(i==0 || j==0)
				{
					t[i][j] = 0;
				}
				
				else if(weight[i-1] > j)
				{
					t[i][j] = t[i-1][j];
				}
				else
				{
					t[i][j] = Math.max(t[i-1][j],value[i-1] + t[i][j - weight[i-1]]);
				}
			}
		}
		
		
		return t[n][w];
	}

	public static void main(String[] args) {
//		int weight[] = {1, 3, 4, 5};
//		int value[] = {10, 40, 50, 70};
//		int w = 8;
		
//		int weight[] = {1, 50};
//		int value[] = {1, 3, 4, 5};
//		int w = 8;
		
		// Same code can solve rod cutting problem
		
		int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int profit[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 8;
		
//		System.out.println(UKnapsack(weight, value, w));
		System.out.println(UKnapsack(length, profit, n));
		
		
		
		

	}

}
