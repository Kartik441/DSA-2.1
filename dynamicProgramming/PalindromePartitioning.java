package dynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {
	
	static int t[][] = new int[10000][10000];
	
	static int solve(String s, int i, int j)
	{
		if(i >= j)
			return 0;
		
		if(isPalindrome(s.substring(i, j+1)))
			return 0;
		
		if(t[i][j] != -1)
			return t[i][j];
		int ans = Integer.MAX_VALUE;
		for(int k = i; k<= j - 1; k++)
		{
			int left, right;
			if(t[i][k]!=-1)
				left = t[i][k];
			else
				left = solve(s, i, k);
			
			if(t[k+1][j]!=-1)
				right = t[k+1][j];
			else
				right = solve(s, k+1, j);
				
			int temp = 1+ left + right;
			
			ans = Math.min(ans, temp);
		}
		
		return ans;
		
		
	}

	static boolean isPalindrome(String s)
	{
		if(s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		
		while(i<j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s = "nitiw";
		
		for(int a[]:t)
			Arrays.fill(a, -1);
		
		System.out.println(solve(s, 0, s.length()-1));
		
	}

}
