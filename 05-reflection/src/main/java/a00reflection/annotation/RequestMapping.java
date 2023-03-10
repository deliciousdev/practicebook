package a00reflection.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})//이 어노테이션을 TYPE 뿐아니라 METHOD 에도 붙일거임
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value() default "";  //url path 를위함

    RequestMethod[] method() default {}; //GET 인지 POST 인지등 어떤 메서드인지

}
