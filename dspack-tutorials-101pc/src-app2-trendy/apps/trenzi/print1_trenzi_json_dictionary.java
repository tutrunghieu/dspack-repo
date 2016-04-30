package apps.trenzi;

import java.io.File;

import apps.trenzi.models.json.Header7;
import ds.util.access.SystemAccess;
import ds.zendy.jsondb.JsonDB;

public class print1_trenzi_json_dictionary {

	public static void main(String[] args) throws Exception 
	{
		JsonDB db = JsonDB.getInstance("/opt/apps/trenzi-102/json-views");
		db.addTables(Header7.class);
		
		File f = SystemAccess.getDesktopFile("out1.txt");
		db.printSchema(f, "txt");
		SystemAccess.openFile(f);
	}

}
