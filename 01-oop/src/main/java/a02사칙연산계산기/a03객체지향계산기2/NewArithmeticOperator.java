package a02사칙연산계산기.a03객체지향계산기2;

import java.util.ArrayList;
import java.util.List;

public interface NewArithmeticOperator {

    boolean supports(String operator);

    int calculate(int operand1, int operand2);
}
