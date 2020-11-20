package heap;

public class MaxHeap {
	
	static int parent(int i)
	{
		return (i-1)/2;
	}
	
	static int leftChild(int i)
	{
		return (2*i)+1;
	}
	
	static int rightChild(int i)
	{
		return (2*i)+2;
	}
	
	static int getMax(int arr[])
	{
		return arr[0];
	}
	
	public static void insert(int heap[],int data)
	{
		int size=size(heap)-1;
		heap[++size]=data;
		
		int i=size;
		while(i>=0)
		{
			if(heap[parent(i)]<heap[i])
			{
				int temp=heap[i];
				heap[i]=heap[parent(i)];
				heap[parent(i)]=temp;
			}
			else
				break;
			
			i=(i-1)/2;
		}

		
	}
	
	static int size(int arr[])
	{
		int size=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
				size++;
			else
				break;
				
		}
		
		return size;
	}
	
	public static void print(int arr[])
	{
		for(int i:arr)
			System.out.print(i+" ");
		
		System.out.println();
	}
	
	public static int extractMax(int heap[])
	{
		if(heap[0]==0)
		{
			System.out.println("Heap is empty");
			return 0;
		}
		int size=size(heap)-1;
		int max=heap[0];
		heap[0]=heap[size];
		heap[size]=0;             // because of personal size function
		size--;
		maxHeapify(heap);
		return max;
		
	}
	
	static void maxHeapify(int []heap)
	{
		int size=size(heap)-1;
		int i=0;
		while(i<=size)
		{
			if(heap[i]<heap[leftChild(i)]||heap[i]<heap[rightChild(i)]){

				int left=heap[leftChild(i)];
				int right=heap[rightChild(i)];
				int max;                 //index of max
				if(left>right)
				{
					max=leftChild(i);				
				}
				else
				{
					max=rightChild(i);
				}
				
				int temp=heap[max];
				heap[max]=heap[i];
				heap[i]=temp;
				
				i=(i-1)/2;
			}
			
			else
			{
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		int heap[]=new int[7];
		insert(heap,10);
		insert(heap,2);
		insert(heap,3);
		insert(heap,4);
		insert(heap,5);
		insert(heap,6);
		insert(heap,17);
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		System.out.println(extractMax(heap));
		print(heap);
		
		

	}

}
