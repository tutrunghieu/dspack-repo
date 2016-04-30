package ds.zendy.jsondb;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonDB 
{
	private String rootFolder;
	private Class<?> rootClass;
	
	public File getDataFolder() 
	{
		return new File(rootFolder);
	}
	
	private List<JsonTable<?>> tables = new ArrayList<JsonTable<?>>();

	public static JsonDB getInstance(String root) 
	{
		JsonDB res = new JsonDB();
		res.rootFolder = root;
		return res;
	}

	public static JsonDB getInstance(String root, Class<?> init) 
	{
		JsonDB res = new JsonDB();
		res.rootFolder = root;
		res.rootClass = init;
		return res;
	}
	
	public JsonTable<?> getTable(int i) 
	{
		return tables.get(i);
	}

	
	public void renderSchema(File f) 
	{
				
	}
	
	private String getDbName() 
	{
		return new File(rootFolder).getName();
	}	

	public<T> JsonTable<T> addTable(Class<T> tab)
	{
		JsonTable<T> res = new JsonTable<T>(tab);
		res.dataFile = new File(this.rootFolder + "/" + res.getActualName() + ".json");
		res.outerDB = this;
		tables.add(res);
		return res;
	}

	public void printSchema(File f, String fmt) throws Exception 
	{
		PrintWriter out = new PrintWriter(f);
		if(fmt.equals("html")) printSchemaHtml(out);
		else if(fmt.equals("txt")) printSchemaText(out);
		out.close();
	}

	public void printSchemaText(PrintWriter out) 
	{
		List<JsonTable<?>> tables1 = tables.stream()
				.sorted(new JsonTableByNumber())
				.collect(Collectors.toList());
		
		for(JsonTable<?> tk: tables1)
		{
			out.println("" + tk.getActualName() + "");
			
			for(JsonField fj : tk.getDataFields()) 
			{
				out.println(tk.getActualName() + "." + fj.getFieldName());
			}
			
			out.println("");
		}		
			
		return;
		
	}
	
	public void printSchemaHtml(PrintWriter out) 
	{
		out.println("<style>");
		out.println("td { padding: 7px; }");
		out.println("</style>");
		
		out.println("<h3>db-root: " + this.getDbName() + "</h3>");
		out.println("<p>db-name: " + this.rootFolder + "</p>");
		out.println("<p>table: " + this.tables.size() + "</p>");
		
		for(JsonTable<?> tk: tables)
		{
			out.println("<h3>" + tk.getActualName() + "</h3>");
//			out.println("<p>source-field: " + tk.getDataFile() + "</p>");
//			out.println("<p>target-class: " + tk.getDataClass() + "</p>");
			
			out.println("<table border=1>");
			for(JsonField fj : tk.getDataFields()) 
			{
				out.println("<tr>");
				out.println("<td style='width:150px;'>" + fj.getFieldName() + "</td>");
//				out.println("<td style='width:150px;'>" + fj.getFieldType().getName() + "</td>");
//				out.println("<td style='width:200px;'>" + Joiner.start("<br>").join(fj.getDaConstrList()) + "</td>");
//				out.println("<td style='width:300px;'>" + Joiner.start("<br>").join(fj.getDaNoteList()) + "</td>");
//				out.println("<td style='width:300px;'>" + Joiner.start("<br>").join(fj.getDaUsingList() ) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("<p>&nbsp;</p>");
		}		
			
		return;
		
	}
	
	public void printSchema(PrintWriter out) 
	{
		out.println("db-root: " + this.rootFolder);
		out.println("db-name: " + this.getDbName());
		
		for(JsonTable<?> tk: tables)
		{
			out.println("--------");
			out.println("table: " + tk.getActualName());
			out.println("source-field: " + tk.getDataFile());
			out.println("target-class: " + tk.getDataClass());
			
			for(JsonField fj : tk.getDataFields()) 
				out.println("field : " + fj.getFieldName() + ": " + fj.getFieldType().getName());
		}		
			
		return;
	}

	public void printSampleRows(PrintWriter out, int n) throws Exception
	{
		for(JsonTable<?> tk: tables)
		{
			tk.loadRows();
			for(Object rj: tk.sample(n) ) out.println(rj);
		}		
			
		return;		
	}

	public void printFirstRows(PrintWriter out, int n) throws Exception
	{
		for(JsonTable<?> tk: tables)
		{
			tk.loadRows();
			for(Object rj: tk.head(n) ) out.println(rj);
		}		
			
		return;		
	}

	public void addTables(Class<?> cl) 
	{
		rootClass = cl;
		
		String name = '/' + rootClass.getName().replace('.', '/') + ".class";

		File f = new File( rootClass.getResource(name).getFile() );
		
		int len = f.getAbsolutePath().length() - name.length() + 1;
		
		for(File fk: f.getParentFile().listFiles())
		if( selectedClass(fk) ) 
		try
		{
			String nk = fk.getAbsolutePath();
			nk = nk.substring(len, nk.length()-6).replace('\\', '/').replace('/', '.');
			//System.out.println(nk);
			
			this.addTable(Class.forName(nk));
		}
		catch(Exception xp) {}

		return;
	}

	protected boolean selectedClass(File fk) 
	{
		if(fk.isDirectory()) return false;
		if(! fk.getName().endsWith(".class")) return false;
		return true;
	}


	
}
