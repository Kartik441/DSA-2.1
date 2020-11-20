package Sorting;
//import Sorting.CountingSort;

public class RadixSort {
	static void countSort(int []a,int n,int pos)
	{
		int []count=new int[10];
		int []b=new int[10];
		for(int i=0;i<n;i++)
		{
			count[(a[i]/pos)%10]++;
		}
		for(int i=1;i<10;i++)
		{
			count[i]+=count[i-1];
		}
		
		for(int i=9;i>=0;i--)
		{
			b[--count[(a[i]/pos)%10]]=a[i];
		}
		for(int i=0;i<n;i++)
		{
			a[i]=b[i];
		}
	}

	public static void main(String[] args) {
		int []a= {432,8,530,90,88,231,11,45,677,199};
		int n=a.length;
		int max=CountingSort.findMax(a);
		for(int pos=1;max/pos>0;pos*=10)
		{
			countSort(a,n,pos);
		}
		for(int i:a)
		{
			System.out.print (i+" ");
		}
	}

}
