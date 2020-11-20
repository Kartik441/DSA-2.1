package dynamicProgramming;

public class PaintFence {
	
	static void solve(int n, int k)
	{
		if(n == 1)
			System.out.println(k);
		
		long same = k * 1;
		long diff = k * (k-1);
		
		long total = same + diff;
		
		if(n == 2)
			System.out.println(total);
		
		for(int i=3;i<=n;i++)
		{
			same = diff * 1;
			diff = total * (k-1);
			total = same + diff;
		}
		System.out.println(total);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(8, 3);
		solve(2, 4);
		solve(3, 2);
	}

}
