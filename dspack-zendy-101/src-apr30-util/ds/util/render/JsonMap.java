package ds.util.render;

import java.util.Map;
import java.util.TreeMap;

public class JsonMap extends JsonResult<Map<String, Object>>
{
	public JsonMap()
	{
		data = new TreeMap<String, Object>();		
	}
	
	public void put(String xk, int vk) 
	{
		data.put(xk, vk);		
	}
}
