package a02사칙연산계산기.a04코드추가필요할때.이넘버전;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(2, "-", 1);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱셈 연산을 수행한다")
    @Test
    void multiplicationTest() {
        int result = Calculator.calculate(2, "*", 3);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("나눗셈 연산을 수행한다")
    @Test
    void divisionTest() {
        int result = Calculator.calculate(6, "/", 3);
        assertThat(result).isEqualTo(2);
    }


    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2,int result){
        assertThat(Calculator.calculate(operand1,operator,operand2)).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult(){//스테틱 메서드
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(7,"-",2,5),
                arguments(4,"*",9,36),
                arguments(8,"/",2,4)
        );
    }

    //객체지향 적으로 잘 짜여져있다면 코드 추가, 수정이 필요할때 수술해야하는 부위가 한정적이고 명확하다
    @DisplayName("0으로 나눴을때 예외발생")
    @Test
    public void exceptionTest() {
        assertThatCode(() -> Calculator.calculate(4, "/", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }
}
