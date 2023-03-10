package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정X;


/**
 * 객체지향적으로 잘 짜여진 코드는 수정이나 추가가 필요할때, 수술해야할 부위가 명확하다
 */
public class DivisionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
//        if(operand2==0) throw new IllegalArgumentException(); //밸류오브젝트 도입하여 필요없어짐
        return operand1.toInt()/operand2.toInt();
    }
}
