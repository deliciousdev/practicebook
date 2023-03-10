package a01테스트코드.a01;

public class PasswordValidator {


    private static String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE="비밀번호는 8자이상 12이하 이어야한다";

    public static void validate(String password) {

        int length = password.length();
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }

    }
}
