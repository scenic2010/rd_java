package scenic.study.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by scenic on 2016/8/24.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAnnotation {
    String value();
    boolean testBoolean() default false;
}
