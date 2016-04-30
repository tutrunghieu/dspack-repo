package ds.util.stream;


public interface ListMapper<S, T> 
{
	public T convert(S obj);
}
