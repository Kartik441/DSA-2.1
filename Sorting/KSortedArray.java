package Sorting;
import heap.MaxHeap;

public class KSortedArray {
	
	static int[] sort(int []arr,int k)
	{
		int n=arr.length;
		int heap[]=new int[n];
		int counter=1;
		int index=n-1;
		while(counter<=k+1)
		{
			MaxHeap.insert(heap, arr[index]);
			index--;
			counter++;
		}

		int i=n-1;               // index For inserting max element at the correct place
		int j= (n-(k+1))-1;      // index For inserting in maxHeap

		while(j>=0)
		{
			arr[i]=MaxHeap.extractMax(heap);
			MaxHeap.insert(heap, arr[j]);
			j--;
			i--;
		}
		while(i>=0)
		{
			arr[i]=MaxHeap.extractMax(heap);
		    i--;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[]= {10,9,8,7,4,70,60,50};//{6,5,3,2,8,10,9};
		int k=4;
		arr=sort(arr,k);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}

//Should try to use miHeap
//That will make things easier
//COmplexity:O(nlog(k))
//AuxiliarySpace:O(k)
