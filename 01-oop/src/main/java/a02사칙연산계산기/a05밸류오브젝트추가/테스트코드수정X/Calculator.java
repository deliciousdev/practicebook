package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정X;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators =
            List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(int operand1, String operator, int operand2) {
        PositiveNumber positive1 = new PositiveNumber(operand1);
        PositiveNumber positive2 = new PositiveNumber(operand2);
        return  operators.stream()
                .filter(o -> o.supports(operator))
                .map(arithmetic -> arithmetic.calculate(positive1, positive2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 operator 입니다"));
    }

}
