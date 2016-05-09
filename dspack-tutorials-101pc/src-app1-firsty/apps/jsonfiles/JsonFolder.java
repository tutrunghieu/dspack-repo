package apps.jsonfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonFolder 
{
	private File rootFolder;
	private List<JsonFile> tables;

	public static JsonFolder getInstance(File f)
	{
		JsonHook h = new JsonHook() 
		{
			ObjectMapper map = new ObjectMapper();
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Object> readList(File f) throws Exception
			{
				return map.readValue(f, List.class);
			}
		};

		return getInstance(f, h);
	}
	
	public static JsonFolder getInstance(File f, JsonHook hook) 
	{
		JsonFolder res = new JsonFolder();
		
		res.rootFolder = f;
		res.tables = new ArrayList<JsonFile>(); 
		
		File[] files = f.listFiles();
		
		if(files != null)
		for(File fk: files)
		if(fk.isFile() && fk.getName().endsWith(".json"))
		{
			res.tables.add(JsonFile.getInstance(fk, hook));
		}
		
		return res;
	}
	
	public List<JsonFile> getTables()
	{
		return tables;
	}

	public File getDataFolder()
	{
		return rootFolder;
	}

}
