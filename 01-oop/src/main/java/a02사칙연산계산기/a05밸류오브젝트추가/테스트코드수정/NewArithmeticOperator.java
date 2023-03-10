package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정;

public interface NewArithmeticOperator {

    boolean supports(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
