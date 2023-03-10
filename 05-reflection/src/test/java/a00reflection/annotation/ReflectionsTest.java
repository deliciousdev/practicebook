package a00reflection.annotation;

import a00reflection.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void controllerScan(){
        Reflections reflections = new Reflections("a00reflection");

        Set<Class<?>> beans = new HashSet<>();//아직 타입이 정해지지않음.(여러타입이 올수 있음)
        //Set<Object> 이랑 비슷한거인듯?

        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        log.debug("beans: [{}]", beans);
    }

    @Test
    void ServiceScan(){
        Reflections reflections = new Reflections("a00reflection");

        Set<Class<?>> beans = new HashSet<>();//아직 타입이 정해지지않음.(여러타입이 올수 있음)
        //Set<Object> 이랑 비슷한거인듯?

        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        beans.addAll(reflections.getTypesAnnotatedWith(Repository.class));

        log.debug("beans: [{}]", beans);
    }

    //등록하고싶은 리스트를 한번에 넘겨주는 방식으로
    @Test
    void multiScan(){
        Reflections reflections = new Reflections("a00reflection");

        Set<Class<?>> beans = getBeanAddedTypesAnnotatedWith(reflections, List.of(Controller.class,Service.class, Repository.class));

        log.debug("beans :[{}]",beans);
    }
    private Set<Class<?>> getBeanAddedTypesAnnotatedWith(Reflections reflections, List<Class<? extends Annotation>> annotations) {

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }

    //Class 클래스 사용해보기



    //Class타입 객체를 가져오기
    @Test
    void classTest() throws ClassNotFoundException {
        Class<User> clazz1 = User.class;

        User user = new User();
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("a00reflection.model.User");

        log.debug("clazz1 = {}", clazz1);
        log.debug("clazz2 = {}", clazz2);
        log.debug("clazz3 = {}", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
    }

    @Test
    void usageClass(){
        Class<User> clazz = User.class;
        log.debug("clazz.getDeclaredMethods() : {}",clazz.getDeclaredMethods());
        log.debug("clazz.getDeclaredConstructors() : {}", clazz.getDeclaredConstructors());
        log.debug("clazz.getDeclaredFields() : {}", clazz.getDeclaredFields());
        System.out.println();
        log.debug("clazz.getDeclaredMethods() : {}", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
        log.debug("clazz.getDeclaredConstructors() : {}", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        log.debug("clazz.getDeclaredFields() : {}", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));

    }


}