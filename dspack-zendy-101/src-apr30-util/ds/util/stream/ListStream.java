package ds.util.stream;


import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream<T> 
{
	protected Stream<T> innerData;
	
	public static<T1> ListStream<T1> stream()
	{
		return new ListStream<T1>(); 
	}

	public static<T1> ListStream<T1> stream(List<T1> st)
	{
		ListStream<T1> res = new ListStream<T1>(); 
		res.innerData = st.stream();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static<T1> ListStream<T1> stream(T1... args)
	{
		ListStream<T1> res = new ListStream<T1>(); 
		
		List<T1> items = new ArrayList<T1>();
		for(T1 ak: args) items.add(ak);
		res.innerData = items.stream();
		return res;
	}
	
	public List<T> toList()
	{
		return innerData.collect(Collectors.toList());
	}
	
	public Set<T> toSet()
	{
		return innerData.collect( Collectors.toSet() );
	}

	public<T1> ListStream<T1> convert(ListMapper<T, T1> mapper)
	{
		List<T1> res = new ArrayList<T1>();
		innerData.forEach(x -> res.add(mapper.convert(x)) );
		return stream(res);
	}
	
	public ListStream<T> select(ListWhere<T> where)
	{
		List<T> res = new ArrayList<T>();
		innerData.forEach(x -> { if(where.selected(x)) res.add(x); });
		return stream(res);
	}

	public ListStream<T> delete(ListWhere<T> where)
	{
		List<T> res = new ArrayList<T>();
		innerData.forEach(x -> { if(! where.selected(x) ) res.add(x); });
		return stream(res);
	}
}
