package queue;

import java.util.LinkedList;
import java.util.Deque;

public class SlidingWindowMaximum {
// variation of this problem is "sum of minimum and maximum elements of all subarray of subsize k"
// total windows will be (n-k)+1 where is total no of element and k is the size of each window	
	static void max(int a[], int k)
	{
		int n = a.length;
		Deque<Integer> dq = new LinkedList<>();
		dq.add(0);
		for(int i = 1;i<k;i++)
		{
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		for(int i = k;i<n;i++)     // i will point to the last element of the window
		{
			System.out.println(a[dq.peekFirst()]);
//			ans[i-k] = a[dq.peekFirst()];
			while(!dq.isEmpty() && dq.peekFirst() <= i-k)
				dq.removeFirst();
			
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()])
				dq.removeLast();
			
			dq.addLast(i);
		}
		System.out.println(a[dq.peekFirst()]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 1};
		int a1[] = {12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		max(a, k);

	}

}
