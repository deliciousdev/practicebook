package a02사칙연산계산기.a05밸류오브젝트추가.테스트코드수정;

public class PositiveNumber {

   private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private boolean validate(int value){
        if(! isPositive(value)) throw new IllegalArgumentException("양수만 가능합니다");
        return true;
    }

    private boolean isPositive(int value) {
        return value>0;
    }

    public int toInt(){
        return this.value;
    }


}
