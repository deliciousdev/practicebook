package a02사칙연산계산기.a03객체지향계산기2;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators =
            List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

//    public static int calculate(int operand1, String operator, int operand2) {
//        NewArithmeticOperator arithmeticOperator = operators.stream()
//                .filter(o -> o.supports(operator))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 operator 입니다"));
//        return arithmeticOperator.calculate(operand1, operand2);
//    }

    public static int calculate(int operand1, String operator, int operand2) {
        return  operators.stream()
                .filter(o -> o.supports(operator))
                .map(arithmetic -> arithmetic.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 operator 입니다"));
    }

}
