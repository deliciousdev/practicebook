package a01테스트코드.a03functionalinterface;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {


    //functional 인터페이스이므로 클래스를 주입하는것이 아니라, 람다를 이용해서 주입할 수도 있음.
    @Test
    void passwordTest(){
        User user = new User();
        user.initPassword(() -> "123");
        assertThat(user.getPassword()).isNull();

        User user2 = new User();
        user.initPassword(()->"1234567890");
        assertThat(user.getPassword()).isNotNull();
    }
}