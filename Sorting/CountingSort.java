package Sorting;

public class CountingSort {
	static int findMax(int []a)
	{
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
				max=a[i];
		}
		
		return max;
	}

	public static void main(String[] args) {
		int []a= {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
		int n=a.length;
		int []b=new int[n];
		int k=findMax(a);
		int []count=new int[k+1];
		for(int i=0;i<n;i++)
		{
			count[a[i]]++;
		}
		for(int i=1;i<k+1;i++)
		{
			count[i]+=count[i-1];
		}
		  
		for(int i=n-1;i>=0;i--)
		{	
			b[--count[a[i]]]=a[i];
		}
	
		for(int i=0;i<n;i++)
		{
			a[i]=b[i];
		}
		for(int i:a)
		{
			System.out.print(i+" ");		
		}
		
	}

}
