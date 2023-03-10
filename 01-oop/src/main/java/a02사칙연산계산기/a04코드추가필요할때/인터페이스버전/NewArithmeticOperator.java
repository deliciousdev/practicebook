package a02사칙연산계산기.a04코드추가필요할때.인터페이스버전;

public interface NewArithmeticOperator {

    boolean supports(String operator);

    int calculate(int operand1, int operand2);
}
