package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정;

public class SubtractionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt()-operand2.toInt();
    }
}
