package recursion;

import java.util.ArrayList;

public class AllCombinationsOfParentheses {
	
	static ArrayList<String> ans = new ArrayList<>();
	
	static int ways = 0;// For 0 combinations ways will give one as ans(edge case)
	
	static void combinations(int open, int close, String str)
	{
		if(open == 0 && close == 0)
		{
			ways+=1;
			//ans.add(str);
			System.out.println(str);
			//str = str.substring(0, str.length() - 2);
			return;
		}
//		if(open == 1 && close == 1)
//		{ 
//			return ;
//		}
		if(open == close)
		{
            // only open bracket can be added
			combinations(open-1, close, str+"{");

		}
		else if(close > open)
		{
			if(open!=0)
			{
				
				combinations(open - 1, close, str+"{");
				
			}
		   
			combinations(open, close - 1, str + "}");
		}
		else
		{
			return;
		}
		
		
	}

	public static void main(String[] args) {
		int n=3;
		combinations(n,n,"");
		System.out.println(ways);

	}

}
