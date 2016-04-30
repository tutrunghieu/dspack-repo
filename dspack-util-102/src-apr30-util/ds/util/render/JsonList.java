package ds.util.render;

import java.util.ArrayList;
import java.util.List;

public class JsonList<T> extends JsonResult<List<T>>
{
	public JsonList()
	{ 
		data = new ArrayList<T>();
	}

	public void add(T t) 
	{
		data.add(t);		
	}

}
