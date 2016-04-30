package apps.firty;

import java.io.PrintWriter;

import apps.firty.models.FirstyProduct;
import apps.firty.models.FirstyUser;
import ds.util.access.SystemAccess;
import ds.zendy.jsondb.JsonDB;
import ds.zendy.jsondb.JsonTable;

public class test1_firsty_dbscript 
{

	public static void main(String[] args) throws Exception 
	{
		String root = SystemAccess.getSystemPrefix("/opt/apps/jsondb1-ui");
		JsonDB db = JsonDB.getInstance(root);

		{
			JsonTable<FirstyUser> t1 = db.addTable(FirstyUser.class);
			t1.truncate();
			t1.insert(new FirstyUser(1, "Anh") );
			t1.insert(new FirstyUser(2, "Binh") );
			t1.insert(new FirstyUser(3, "Cuong") );
			t1.insert(new FirstyUser(4, "Trung") );
			t1.insert(new FirstyUser(5, "Duc") );
			t1.insert(new FirstyUser(6, "Hai") );
			t1.insert(new FirstyUser(7, "Nam") );
			
			t1.delete(x -> x.userName.equals("Hai"));
			t1.saveRows();			
		}
		
		{
			JsonTable<FirstyProduct> t2 = db.addTable(FirstyProduct.class);
			
			t2.truncate();
			t2.insert(new FirstyProduct(1, "Quan") );
			t2.insert(new FirstyProduct(2, "Ao") );
			t2.insert(new FirstyProduct(3, "Giay") );
			t2.insert(new FirstyProduct(4, "Dep") );
			t2.insert(new FirstyProduct(5, "Khan") );
			
			t2.delete(x -> x.prodName.equals("Ao"));
			t2.update(x -> { x.prodPrice = JsonTable.getCoin().nextInt(9999) + ""; }, x -> true);
			t2.saveRows();			
		}
		
		
		PrintWriter out = SystemAccess.getDesktopWriter("out1.txt");
		db.printSchema(out);
		db.printFirstRows(out, 10);
		out.close();
		
		SystemAccess.openDesktopFile("out1.txt");
		
		System.out.println("Database generated at " + db.getDataFolder());
	}

}
