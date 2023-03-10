package a02사칙연산계산기.a04코드추가필요할때.이넘버전;


import java.util.Arrays;

/**
 * 객체지향적으로 잘 짜여진 코드는 수정이나 추가가 필요할때, 수술해야할 부위가 명확하다
 */
public enum ArithmeticOperator {

    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1+operand2;
        }
    } ,
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1-operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1*operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            if(operand2==0) throw new IllegalArgumentException("0으로 나눌 수 없습니다");

            return operand1/operand2;
        }
    },
    ;

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }


    //이부분이 외부에 노출되는 public 인터페이스 : Calculator 가 이 메서드를 통해서 작업을 위임해줄거임
    public static int calculate(final int operand1, final String operator,final int operand2){
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(instance -> instance.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 operator 입니다"));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }


    //values()로 이넘 객체들 배열로 반환받을수있음음
   protected abstract int arithmeticCalculate(int operand1, int operand2) ;

}
