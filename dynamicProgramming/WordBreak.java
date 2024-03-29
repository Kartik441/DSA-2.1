package dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class WordBreak {
// recursive solution
	// TC: O(2^n)
	static boolean wordBreakRec(String s, HashSet<String> dict)
	{
		if(s.equals(""))
			return true;
		
		for(int i=0;i<s.length();i++)
		{
			if(dict.contains(s.substring(0, i+1)) && wordBreakRec(s.substring(i+1), dict))
				return true;
		}
		return false;
	}
	
	// Memoized version
	static HashMap<String, Boolean> map = new HashMap<>();
	static boolean wordBreakMem(String s, HashSet<String> dict)
	{

		if(s.equals(""))
			return true;
		
		if(map.containsKey(s))
			return map.get(s);
		
		for(int i=0;i<s.length();i++)
		{
			if(dict.contains(s.substring(0, i+1)) && wordBreakMem(s.substring(i+1), dict))
			{
				map.put(s.substring(i+1), true);
				return true;
			}
		}
		return false;
	}
	
	// dp solution
	
	
	static boolean wordBreak(String s, HashSet<String> dict)
	{
		boolean t[] = new boolean[s.length() + 1];
		
		t[0] = true;
		
		for(int len=1; len <= s.length(); len++)
		{
			for(int i=0; i<len ; i++)
			{
				if(t[i] && dict.contains(s.substring(i, len)))
				{
					t[len] = true;
					break;
				}
			}
		}
		
		return t[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		HashSet<String> dict = new HashSet<>();
//		dict.add("c");
//		dict.add("od");
//		dict.add("e");
//		dict.add("x");
		//dict.add("code");
//		System.out.println(wordBreakRec("code", dict));
//		System.out.println(wordBreakMem("code", dict));
//		System.out.println(wordBreak("code", dict));
		
		HashSet<String> dict = new HashSet<>();
		dict.add("i");
		dict.add("like");
		dict.add("sam");
		dict.add("sung");
		dict.add("samsung");
		dict.add("mobile");
		dict.add("ice");
		dict.add("cream");
		dict.add("icecream");
		dict.add("man");
		dict.add("go");
		dict.add("mango");
		
		System.out.println(wordBreakRec("ilike", dict));
		System.out.println(wordBreakMem("ilike", dict));
		System.out.println(wordBreak("ilike", dict));
		
		System.out.println(wordBreakRec("ilikesamsung", dict));
		System.out.println(wordBreakMem("ilikesamsung", dict));
		System.out.println(wordBreak("ilikesamsung", dict));
		
		
	}

}
