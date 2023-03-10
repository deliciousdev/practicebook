package a01테스트코드.a03functionalinterface;

public class WrongFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "12";
    }
}
