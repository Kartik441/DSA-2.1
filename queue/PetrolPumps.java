package queue;

// find the first circular tour that visits all petrol pumps
public class PetrolPumps {
	
	static class petrolPump 
    { 
        int petrol; 
        int distance; 
          
        // constructor 
        public petrolPump(int petrol, int distance)  
        { 
            this.petrol = petrol; 
            this.distance = distance; 
        } 
    } 
	// TC:O(n)
	// SC:O(1)
	static int printTour(petrolPump a[])
	{
		int n = a.length;
		
		int petrol = a[0].petrol - a[0].distance;
		int start = 0;
		int end = 1;
		// if current amount of petrol in truck becomes less than 0, then remove the starting petrol pump from the tour
		while(end != start || petrol < 0)
		{
			while(petrol < 0 && start!=end)
			{
				// removing starting petrol pump. change start
				petrol -= a[start].petrol - a[start].distance;
				start = (start + 1)%n;
				if(start == 0)             // if checked all possible values
					return -1;
			}
			// add  a petrol pump to current tour
			petrol += a[end].petrol - a[end].distance;
			end = (end+1)%n;
		}
		return start;
		
	}

	public static void main(String[] args) {
		
		petrolPump a[] = {new petrolPump(6, 4),
				new petrolPump(3, 6),
				new petrolPump(7, 3)
		};
		
		System.out.println(printTour(a));
		

	}

}
