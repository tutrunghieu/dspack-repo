package apps.jsonfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class JsonFile {

	private File dataFile;
	private List<Object> dataRows;
	private List<String> dataFieldNames;
	private JsonHook dataReader;

	public static JsonFile getInstance(File fk, JsonHook json) 
	{
		JsonFile res = new JsonFile();
		res.dataFile = fk;
		res.dataReader = json;
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getFieldNames() throws Exception
	{
		if(dataFieldNames != null) return dataFieldNames;		
		
		dataFieldNames = new ArrayList<String>();
		
		Set<String> used = new TreeSet<String>();
		
		dataRows = dataReader.readList(dataFile); 
		
		for(Object rk: dataRows)
		{
			Map<String, Object> ek = (Map<String, Object>)rk;
			
			for(String fj: ek.keySet())
			if(! used.contains(fj) )
			{
				dataFieldNames.add(fj);
				used.add(fj);
			}
		}
		
		return dataFieldNames;
	}

	public String getDataFileName() 
	{
		return dataFile.getName();
	}

	public File getDataFile() 
	{
		return dataFile;
	}
}
