package ds.zendy.metag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DaUsing1 {

	Class<?> value();

}
