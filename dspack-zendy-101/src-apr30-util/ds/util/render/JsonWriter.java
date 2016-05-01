package ds.util.render;

import java.io.File;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonWriter {

	public static JsonWriter start() 
	{
		return new JsonWriter();
	}

	public void write(PrintWriter f, Object obj) 
	{
		try 
		{ 
			(new ObjectMapper()).writeValue(f, obj);
		}
		catch(Exception xp) { }
	}

	public void write(File f, Object obj) 
	{
		try 
		{ 
			PrintWriter out = new PrintWriter(f);
			(new ObjectMapper()).writeValue(out, obj); 
			out.close();		
		}
		catch(Exception xp) { }
	}


}
