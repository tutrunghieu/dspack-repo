package ds.zendy.jsondb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaContr1;
import ds.zendy.metag.DaContr2;
import ds.zendy.metag.DaContr3;
import ds.zendy.metag.DaNote1;
import ds.zendy.metag.DaNote2;
import ds.zendy.metag.DaNote3;
import ds.zendy.metag.DaUsing1;
import ds.zendy.metag.DaUsing2;
import ds.zendy.metag.DaUsing3;

public class JsonField {

	protected JsonTable<?> outerTable;
	protected Field targetField;

	public JsonField(JsonTable<?> tab, Field field) 
	{
		outerTable = tab;
		targetField = field;
	}

	public String getFieldName() 
	{
		return targetField.getName();
	}

	public Class<?> getFieldType() 
	{
		return targetField.getType();
	}

	public List<String> getDaNoteList() 
	{
		List<String> res = new ArrayList<String>();
		
		{
			DaNote1 s1 = targetField.getAnnotation(DaNote1.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}
		
		{
			DaNote2 s1 = targetField.getAnnotation(DaNote2.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}
		
		{
			DaNote3 s1 = targetField.getAnnotation(DaNote3.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}

		return res;
	}

	public List<String> getDaConstrList() 
	{
		List<String> res = new ArrayList<String>();
		
		{
			DaContr1 s1 = targetField.getAnnotation(DaContr1.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}
		
		{
			DaContr2 s1 = targetField.getAnnotation(DaContr2.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}

		{
			DaContr3 s1 = targetField.getAnnotation(DaContr3.class);
			if(s1 != null && !s1.value().isEmpty()) res.add(s1.value());
		}
		
		return res;
	}

	public List<String> getDaUsingList() 
	{
		List<String> res = new ArrayList<String>();
		
		{
			DaUsing1 s1 = targetField.getAnnotation(DaUsing1.class);
			if(s1 != null ) res.add(s1.value().getName());
		}
		
		{
			DaUsing2 s1 = targetField.getAnnotation(DaUsing2.class);
			if(s1 != null ) res.add(s1.value().getName());
		}

		{
			DaUsing3 s1 = targetField.getAnnotation(DaUsing3.class);
			if(s1 != null ) res.add(s1.value().getName());
		}
		
		return res;
	}
	
}
