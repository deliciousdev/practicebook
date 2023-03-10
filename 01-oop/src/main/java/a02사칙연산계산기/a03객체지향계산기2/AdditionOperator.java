package a02사칙연산계산기.a03객체지향계산기2;

public class AdditionOperator implements NewArithmeticOperator{



    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1+operand2;
    }
}
