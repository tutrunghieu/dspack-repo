package ds.util.stream;


import java.util.Map;
import java.util.TreeMap;

public class JsonMapStream 
{
	protected Map<String, Object> innerData = new TreeMap<String, Object>();		
	 
	public static JsonMapStream stream()
	{
		return new JsonMapStream();
	}
	
	public JsonMapStream put(String xk, Object yk)
	{
		innerData.put(xk, yk);
		return this;
	}
	
	public Map<String, Object> unbox()
	{
		return innerData;
	}

}
