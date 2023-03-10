package a01테스트코드.a01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {



    //테스트 하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음
    //시나리오 : 여러 유저가 비밀번호를 들고 들어옴 ( 랜던한 비밀번호가 들어오게됨) : given when then 구조로 나타낼수 있음
    //스태틱한 코드로 랜덤한 인풋들을 검증할려다보니 테스트 검증 하기가 쉽지않다 -> 랜덤으로 발생되는 번호를 컨트롤할 필요가 있음
    @DisplayName("패스워드를 초기화한다")
    @Test
    void name() {
        //given : 전체적인 조건 상황
        User user = new User();

        //when :어떤 시나리오가 일어남
        user.initPassword();

        //then : 내가 검증하고자 하는거 ( 내가 기대하는거)
        assertThat(user.getPassword()).isNotNull();
    }
}