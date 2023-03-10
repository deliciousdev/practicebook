package a02사칙연산계산기.a01기본계산기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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


    //@ParameterizedTest , @MethodSource()를 이용해보자
    @ParameterizedTest
    @MethodSource("formulaAndResult") //formulaAndReuslt라는 이름을 가진 메서드의 리턴값을 소스로 이용할 것이다
    void calculateTest(int operand1, String operator, int operand2,int result){
        assertThat(Calculator.calculate(operand1,operator,operand2)).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult(){//소스가될 메서드는 static 이어야함
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(7,"-",2,5),
                arguments(4,"*",9,36),
                arguments(8,"/",2,4)
        );
    }

}
