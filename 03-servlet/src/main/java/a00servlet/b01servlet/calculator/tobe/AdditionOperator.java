package a00servlet.b01servlet.calculator.tobe;


import a00servlet.b01servlet.calculator.domain.PositiveNumber;

public class AdditionOperator implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();
    }
}