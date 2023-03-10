package a01테스트코드.a02랜덤패스워드컨트롤;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {


    @DisplayName("올바른 패스워드상황에서 패스워드를 초기화한다")
    @Test
    void passwordTest() {
        User user = new User();
        user.initPassword(new CorrectFixedPasswordGenerator());

        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("올바르지 못한 패스워드 상황에서는 패스워드가 초기화 되지 않는다")
    @Test
    void passwordTest2(){
        User user = new User();
        user.initPassword(new WrongFixedPasswordGenerator());

        assertThat(user.getPassword()).isNull();
    }
}