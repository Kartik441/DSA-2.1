package dynamicProgramming;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;





public class WordWrap {

	
	static void solve(String a[])
	{
		
		Arrays.sort(a, new Comparator<String>() {// using anonymous class
			public int compare(String s1, String s2) 
			{
				int n = s1.length();
				int m = s2.length();
				
				
					int i = n-1;
					int j = n-1;
					int a = m-1;
					int b = m-1;
					while(s1.charAt(i) != '/')
					{
						i--;
					}
					int year1 = Integer.parseInt(s1.substring(i+1, j+1));
					j = i-1;
					i--;
					while(s2.charAt(a) != '/')
					{
						a--;
					}
					int year2 = Integer.parseInt(s2.substring(a+1, b+1));
					b = a-1;
					a--;
					
					if(year1 < year2)
						return -1;
					
					else if(year1 > year2)
						return 1;
					
					// if year same than checking for month
					while(s1.charAt(i) != '/')
					{
						i--;
					}
					int month1 = Integer.parseInt(s1.substring(i+1, j+1));
					j = i-1;
					i--;
					while(s2.charAt(a) != '/')
					{
						a--;
					}
					int month2 = Integer.parseInt(s2.substring(a+1, b+1));
					b = a-1;
					a--;
					
					if(month1 < month2)
						return -1;
					
					else if(month1 > month2)
						return 1;
					
					
					// if month is also same than checking for date
					
					int date1 = Integer.parseInt(s1.substring(0, j+1));
					int date2 = Integer.parseInt(s2.substring(0, b+1));
					
					if(date1 < date2)
						return -1;
					
					else if(date1 > date2)
						return 1;
					
					else return 0;
				
			}
		});
		
		for(String s:a)
			System.out.println(s);
	}
	
	static int check(String s1, String s2)
	{
		int n = s1.length();
		int m = s2.length();
		
		
			int i = n-1;
			int j = n-1;
			int a = m-1;
			int b = m-1;
			while(s1.charAt(i) != '/')
			{
				i--;
			}
			int year1 = Integer.parseInt(s1.substring(i+1, j+1));
			j = i-1;
			i--;
			while(s2.charAt(a) != '/')
			{
				a--;
			}
			int year2 = Integer.parseInt(s2.substring(a+1, b+1));
			
			b = a-1;
			a--;
			
			if(year1 < year2)
				return -1;
			
			else if(year1 > year2)
				return 1;
			
			// if year same than checking for month
			while(s1.charAt(i) != '/')
			{
				i--;
			}
			int month1 = Integer.parseInt(s1.substring(i+1, j+1));
			j = i-1;
			i--;
			while(s2.charAt(a) != '/')
			{
				a--;
			}
			int month2 = Integer.parseInt(s2.substring(a+1, b+1));
			b = a-1;
			a--;
			
			if(month1 < month2)
				return -1;
			
			else if(month1 > month2)
				return 1;
			
			
			// if month is also same than checking for date
			System.out.println("Ymonth" + i );
			
//			while(i >= 0 && s1.charAt(i) != '/')
//			{
//				i--;
//			}
//			int date1 = Integer.parseInt(s1.substring(i+1, j+1));
//			j = i-1;
//			i--;
//			while(s2.charAt(a) != '/')
//			{
//				a--;
//			}
//			int date2 = Integer.parseInt(s2.substring(a+1, b+1));
//			b = a-1;
//			a--;
//			d
			int date1 = Integer.parseInt(s1.substring(0, j+1));
			int date2 = Integer.parseInt(s2.substring(0, b+1));
			System.out.println(date1);
			System.out.println(date2);
			if(date1 < date2)
				return -1;
			
			else if(date1 > date2)
				return 1;
			
			else return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = {"8/7/2000",
				"31/7/2000",
				"12/11/2",
				"31/7/2000"
		};
		String s1[] = { "9/9/2000",
				"8/9/2008",
				"12/11/2006",
		};
//		Scanner s = new Scanner(System.in);
//		String s1[] = new String[]
		//solve(s);
//		System.out.println(check("9/9/2008", "8/9/2008"));
//		12/11/2006
//		8/9/2008
//		9/9/2008
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String a[] = new String[n];
		
		for(int i=0;i<n;i++)
		{
			a[i] = sc.next();
		}
		
//		for(String str:a)
//			System.out.println(str);
		solve(a);
	}

}
