package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다")
    @Test
    void additionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(new PositiveNumber(2), "-", new PositiveNumber(1));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱셈 연산을 수행한다")
    @Test
    void multiplicationTest() {
        int result = Calculator.calculate(new PositiveNumber(2), "*", new PositiveNumber(3));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("나눗셈 연산을 수행한다")
    @Test
    void divisionTest() {
        int result = Calculator.calculate(new PositiveNumber(6), "/", new PositiveNumber(3));
        assertThat(result).isEqualTo(2);
    }


    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        assertThat(Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2))).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {//스테틱 메서드
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(7, "-", 2, 5),
                arguments(4, "*", 9, 36),
                arguments(8, "/", 2, 4)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void negativeTest(int value){
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void negativeTest2(int value){
        assertThatCode(() -> Calculator.calculate(
                new PositiveNumber(1),"+", new PositiveNumber(value)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 가능합니다");
    }
}
