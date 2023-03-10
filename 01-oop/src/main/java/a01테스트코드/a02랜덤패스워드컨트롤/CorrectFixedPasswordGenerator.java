package a01테스트코드.a02랜덤패스워드컨트롤;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "1234567890";
    }
}
