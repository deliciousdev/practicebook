package a02사칙연산계산기.a04코드추가필요할때.인터페이스버전;

public class AdditionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1+operand2;
    }
}
