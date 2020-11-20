package dynamicProgramming;

public class StockSpan {
	//If only two transactions are allowed
		
	static int maxProfit(int price[])
	{
		int n = price.length;
		int lsf = Integer.MAX_VALUE;
		int op = 0;   // overall profit
		int pist = 0;  // profit if sold today
		
		for(int i=0;i<n;i++)
		{
			if(price[i] < lsf)
				lsf = price[i];
			pist = price[i] - lsf;
			op = Math.max(pist, op);
		}
		return op;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {2, 30, 15, 10, 8, 25, 80};
		System.out.println(maxProfit(price));

	}

}
