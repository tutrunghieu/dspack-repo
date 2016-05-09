package apps.jsonfiles;

import java.io.File;

public class usecase1_printing_schema
{
	public static void main(String[] args) throws Exception
	{
		File f = new File("c:/opt/apps/jsondb1-ui");
		JsonFolder db = JsonFolder.getInstance(f);
		
		for(JsonFile tk: db.getTables())
		{
			System.out.println("table:" + tk.getDataFileName() );
			for(String fj: tk.getFieldNames()) System.out.println("field:" + fj);				
		}
	}

//	private static JsonHook getJsonHook()
//	{
//		return new JsonHook() {
//			ObjectMapper map = new ObjectMapper();
//			
//			@SuppressWarnings("unchecked")
//			@Override
//			public List<Object> readList(File f) throws Exception
//			{
//				return map.readValue(f, List.class);
//			}};
//	}

}
