package a00was.a톰캣구현.calculator.tobe;


import a00was.a톰캣구현.calculator.domain.PositiveNumber;

public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);
}
