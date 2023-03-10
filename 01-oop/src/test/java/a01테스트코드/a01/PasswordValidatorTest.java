package a01테스트코드.a01;


import a01테스트코드.a01.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 비밀번호는 최소 8자 이상 12자 이하여야한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {


    //테스트코드를 먼저 만들어 놓고 빠르게 테스트 코드를 빠르게 실행 시키는 방향으로....
    //아무것도 없는 상태에서 테스트 코드를 작성하고 컴파일만 되도록 만든다.
    //PasswordValidator.validate(String) 부분이 컴파일 되지 않지만 이 메서드를 만들어줌으로써 컴파일이 되도록 일단 만든다
    //이테스트를 일단은 통과시키고난후 PasswordValidator.validate(String) 를 요구사항에 맞춰가면서 리팩토링한다
    //테스트코드가 pass인 상황을 깨지않는것을유지하면서 리팩토링을 진행한다

    //이 문구로인해 테스트코드는 문서화 역할도함
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("12345678"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자미만, 12자초과이면 IllegalArgumentException이 발생한다")
    @Test
    void validatePasswordTest2(){
        assertThatCode(() -> PasswordValidator.validate("1234567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자이상 12이하 이어야한다");
    }


    //대부분 경계조건(크리티컬한 조건) 에서 오류가 많이 나므로 꼭 테스트코드로 검증해주자
    //@ParameterizedTest, @ValueSource 를 사용하여 여러개의 크리티컬한 조건들을 테스트해주자
    //이 어노테이션에 대해서는
    //https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
    //여기를 참고하자
    //실무에서 정말 많이 사용함
    ///여기에서 @Test 라는 어노테이션은 있으면안됨
    @DisplayName("7자, 13자 가 크리티컬 오류조건임.")
    @ParameterizedTest
    @ValueSource(strings = {"1234567","1234567890123"}) //이것들은 아래 메서드의 파라미터로 들어가게됨
    void validatePasswordTest3(String password){
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자이상 12이하 이어야한다");
    }






}
