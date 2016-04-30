package ds.util.access;

import java.awt.Desktop;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SystemAccess {

//	public static Random coin = new Random(197);

	public static String getSystemPrefix()
	{
		return "c:";
	}

	public static String getSystemPrefix(String f)
	{
		return "c:" + f;
	}
	
	public static File getDesktopFile(String f)
	{
		return new File(System.getProperty("user.home") + "/Desktop/" + f);
	}

	public static PrintWriter getDesktopWriter(String f) throws Exception
	{
		File sf = getDesktopFile(f);
		sf.getParentFile().mkdirs();
		return new PrintWriter(sf);
	}

	public static void openDesktopFile(String fn) throws Exception
	{
		File f = getDesktopFile(fn);
		Desktop.getDesktop().open(f);		
	}

	public static void openFile(File f) throws Exception
	{
		Desktop.getDesktop().open(f);				
	}

	public static String getExecutedClass()
	{
		StackTraceElement[] e = Thread.currentThread().getStackTrace();
		for(StackTraceElement ek: e)
		{
			//System.out.printf("%s %s\n", ek.getClassName(), ek.getMethodName());
			if(ek.getMethodName().equals("main")) return ek.getClassName();
		}
		
		return null;
	}

	public static Integer[] getNumbersFromName(String name) 
	{
		List<Integer> res = new ArrayList<Integer>();
		
		for(String sk: name.replaceAll("\\D+", ";").split(";"))
		{
			//System.out.println(sk);
			if(! sk.isEmpty()) res.add(Integer.parseInt(sk));
		}
		
		return res.toArray(new Integer[] {});
	}
	

}
