package a00servlet.b01servlet.calculator.tobe;


import a00servlet.b01servlet.calculator.domain.PositiveNumber;

public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);
}
