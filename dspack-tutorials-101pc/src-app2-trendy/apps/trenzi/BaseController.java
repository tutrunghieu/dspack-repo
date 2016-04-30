package apps.trenzi;

import java.io.File;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds.util.access.SystemAccess;
import ds.util.render.JsonResult;
import ds.util.render.JsonWriter;

public class BaseController 
{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String uri1;
	protected String uri2;
	protected String uri3;
	protected String urlFull;
	protected String url0;
	protected String url1;
	
	public String getParameter(String name, String dv)
	{
		String val = request.getParameter(name);
		return val==null ? dv : name;
	}
	

	
	protected static File output = SystemAccess.getDesktopFile("out1.txt");
	

	public static void test(String name) throws Exception
	{
		String s = SystemAccess.getExecutedClass();
		testUrl(Class.forName(s), name);
	}

	public static void testUrl(Class<?> cl, String name) throws Exception
	{
		Method m = cl.getMethod(name + "Action");
		Object res = m.invoke(cl.newInstance());

		JsonWriter.start().write(output, res);
		SystemAccess.openFile(output);		
	}

	public JsonResult<String> error(int i, Class<?> cl)
	{
		JsonResult<String> res = new JsonResult<String>();
		res.error = i;
		res.data = cl.getName();
		return res;
	}

	public JsonResult<String> error(int i, Exception cl)
	{
		JsonResult<String> res = new JsonResult<String>();
		res.error = i;
		res.data = cl.getClass().getName();
		return res;
	}
	
	public JsonResult<String> error0(String msg)
	{
		JsonResult<String> res = new JsonResult<String>();
		res.error = 0;
		res.data = msg;
		return res;		
	}
	
	public JsonResult<String> error0()
	{
		JsonResult<String> res = new JsonResult<String>();
		res.error = 0;
		res.data = "Done!";
		return res;		
	}

	public void setUri123(String ak, String ck, String mk) 
	{
		uri1 = "/" + ak;
		uri2 = uri1 + "/" + ck;
		uri3 = uri2 + "/" + mk;				
	}

	public void setUrl01(String u) 
	{ 
		urlFull = u;
		url0 = u.substring(0, u.indexOf('/', 8));
		url1 = url0 + "/" + uri1;
	}


}
