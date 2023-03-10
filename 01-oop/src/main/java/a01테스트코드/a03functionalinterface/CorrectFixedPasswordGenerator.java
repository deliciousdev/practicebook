package a01테스트코드.a03functionalinterface;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "1234567890";
    }
}
