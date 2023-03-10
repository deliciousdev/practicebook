package a00reflection.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})//TYPE 에 붙이는 어노테이션 ( Class, Interface , Annotation, Enum)
@Retention(RetentionPolicy.RUNTIME)// 이 어노테이션 정보는 런타임에도 유지됨
public @interface Controller {

}
