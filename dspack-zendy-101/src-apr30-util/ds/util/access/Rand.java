package ds.util.access;

import java.util.Random;

public class Rand {

	public static Random coin = new Random(197);
	
	public static String string(int a, int b)
	{
		return string(nextLen(a, b));
	}
	
	public static String string(int len)
	{
		String res = "";
		for(int k=0; k<len; k++)
		{
			res += (char)( 'a' + coin.nextInt('z' - 'a') );
		}

		return res;
	}

	public static int nextLen(int a, int b) 
	{
		return a + coin.nextInt(b - a);
	}

	public static String nextUrl(int len) 
	{
		return "http://" + string(len);
	}

}
