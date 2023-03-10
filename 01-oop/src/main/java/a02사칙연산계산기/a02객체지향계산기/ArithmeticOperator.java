package a02사칙연산계산기.a02객체지향계산기;


import java.util.Arrays;

/**
 * 외부에 인터페이스를 두고 그 인터페이스를 통해서 요청이 오면, 파라미터를 받아 내부적으로 어떤 객체가 시행될지 정한 요청을 처리함
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
