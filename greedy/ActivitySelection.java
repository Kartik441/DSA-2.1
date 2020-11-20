package greedy;

public class ActivitySelection {
	
	// here end time is sorted
	static void maxActivities(int s[], int e[])
	{
		System.out.println(s[0] +" "+ e[0]);
		int j=0;      // it will point to the last chosen activity 
		for(int i=1;i<s.length;i++)
		{
			if(s[i] > e[j])
			{
				// than this activity can be include
				System.out.println(s[i]+" "+e[i]);
				j = i;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] =  {1, 3, 0, 5, 8, 5}; 
	    int f[] =  {2, 4, 6, 7, 9, 9}; 
	    maxActivities(s, f);

	}

}
