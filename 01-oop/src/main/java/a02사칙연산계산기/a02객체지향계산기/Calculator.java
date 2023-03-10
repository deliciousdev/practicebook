package a02사칙연산계산기.a02객체지향계산기;

public class Calculator {

    public static int calculate(int operand1, String operator, int operand2){
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
