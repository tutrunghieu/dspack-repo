package apps.jsonfiles;

import java.io.File;
import java.util.List;

public interface JsonHook 
{
	public List<Object> readList(File dataFile) throws Exception;

}
