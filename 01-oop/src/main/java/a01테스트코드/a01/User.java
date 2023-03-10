package a01테스트코드.a01;


import lombok.Getter;

@Getter
public class User {

    private String password;

    //User 는 RandomPasswordGenerator 를 직접 쓰고 있음
    public void initPassword(){

        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = randomPasswordGenerator.generatePassword();

        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }



}
