package a02사칙연산계산기.a01기본계산기;

public class Calculator {


    public static int calculate(int operand1, String operator, int operand2) {

        int result= Integer.MIN_VALUE;
        switch (operator){
            case "+":
                result= operand1+operand2; break;
            case "-":
                result= operand1-operand2; break;
            case "*":
                result = operand1*operand2; break;
            case "/":
                result = operand1/operand2; break;
        }

        return result;
    }
}
