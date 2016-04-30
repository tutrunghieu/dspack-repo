package ds.zendy.metag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SiteNote {

	String Meaning() default "";
	String value() default "";
	String Number() default "";
	String Rename() default "";
	String Example() default "";
	String ImageUrl() default "";
	String Done() default "";
	Class<?>[] Concepts() default {};

}
