package a02사칙연산계산기.a04코드추가필요할때.인터페이스버전;


/**
 * 객체지향적으로 잘 짜여진 코드는 수정이나 추가가 필요할때, 수술해야할 부위가 명확하다
 */
public class DivisionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if(operand2==0) throw new IllegalArgumentException("0으로 나눌 수 없습니다");

        return operand1/operand2;
    }
}
