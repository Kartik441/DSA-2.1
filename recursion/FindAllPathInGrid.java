package recursion;

public class FindAllPathInGrid {
	
	static int paths(int rows, int columns)         //A Grid         
	{
		if(rows == 1 || columns == 1)
			return 1;
		
		return paths(rows, columns-1) + paths(rows-1, columns);
	}

	public static void main(String[] args) {
		
		System.out.println(paths(4,4));
		

	}

}
