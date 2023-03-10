package a02사칙연산계산기.a04코드추가필요할때.인터페이스버전;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators =
            List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(int operand1, String operator, int operand2) {
        return  operators.stream()
                .filter(o -> o.supports(operator))
                .map(arithmetic -> arithmetic.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 operator 입니다"));
    }

}
