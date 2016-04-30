package ds.zendy.jsondb;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ds.util.render.JsonReader;
import ds.util.render.JsonWriter;


public class JsonTable<T>
{
	public static Random __coin;
	
	public static Random getCoin() 
	{
		if(__coin != null) return __coin;
		return __coin = new Random(197);
	}
	
	protected Class<T> rowClass;
	protected List<T> rows = new ArrayList<T>();
	protected List<JsonField> fields;
	
	protected File dataFile;
	protected JsonDB outerDB;
	
	public JsonTable(Class<T> tab) 
	{
		rowClass = tab;
	}

	public String getActualName() 
	{
		return rowClass.getSimpleName();
	}

	public File getDataFile()
	{
		return dataFile;
	}

	public List<JsonField> getDataFields()
	{
		if(fields != null) return fields;
		
		fields = new ArrayList<JsonField>();
		
		for(Field fk: rowClass.getFields())
		if( selectedField(fk) )	fields.add( new JsonField(this, fk) );
		
		return fields;
	}

	protected boolean selectedField(Field fk) 
	{
		return true;
	}

	public Class<T> getDataClass() 
	{
		return rowClass;
	}


	@SuppressWarnings("unchecked")
	public void loadRows() throws Exception
	{
		File f = this.getDataFile();
		if(!f.exists()) return;
		
		rows = (List<T>)JsonReader.start().readList(f);
	}

	public void saveRows() throws Exception
	{
		File f = this.getDataFile();
		f.getParentFile().mkdirs();
		JsonWriter.start().write(f, rows);
	}

	public void insert(T row) 
	{
		rows.add(row);
	}

	public void truncate() 
	{
		File f = this.getDataFile();
		if(f.exists()) f.delete();
		rows = new ArrayList<T>();
	}

	public void delete(JsonWhere<T> lf) 
	{
		List<T> res = new ArrayList<T>();
		for(T rk: rows) if( ! lf.selectedRow(rk) ) res.add(rk); 
		rows = res;
	}

	public List<T> head(int n) 
	{
		n = Math.min(n, rows.size());
		return rows.subList(0, n);
	}
	
	
	public T sampleOne() 
	{
		int n = getCoin().nextInt(rows.size());
		return rows.get(n);
	}

	public List<T> sample(int n) 
	{
		List<T> res = new ArrayList<T>();
		for(int len=rows.size(), k=0; k<n; k++)
		{
			int rk = getCoin().nextInt(len);
			res.add( rows.get(rk) );
		}

		return res;
	}

	public void update(JsonReplace<T> lf, JsonWhere<T> where) 
	{
		for(T rk: rows) if( where.selectedRow(rk) ) lf.updateRow(rk);		
	}
	
}
