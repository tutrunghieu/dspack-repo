package ds.util.render;

import java.io.File;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;



public class JsonReader 
{
	public static JsonReader start() 
	{
		return new JsonReader();
	}

	public List<?> readList(File f) throws Exception
	{
		return (new ObjectMapper()).readValue(f, List.class);
	}
	
	@SuppressWarnings("unchecked")
	public<T> List<T> readList(File f, Class<T> cl) throws Exception
	{
		return (new ObjectMapper()).readValue(f, List.class);
	}
}
