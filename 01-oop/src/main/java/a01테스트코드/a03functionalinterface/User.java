package a01테스트코드.a03functionalinterface;


import lombok.Getter;

@Getter
public class User {

    private String password;


    //랜덤한 상황을 컨트롤 하기 위해, RandomPasswordGenerator 을 직접 쓰지말고 외부로부터 주입받자.
    //기존에 User는 RandomPasswordGenerator 라는 구체 클래스에 의존적이였음. 이를 인터페이스에 의존적으로 만들어줬음
    //랜덤한 상황을 테스트로 돌리기위해 CorrectFixed, WrongFixed 로 나누고, PasswordGenerator를 외부에서 주입받고록 만들었음.
    //결국 이러한 변화는
    //실제 운영에서는 RandomPasswordGenerator 가 사용 되고, CorrectFixedPasswordGenerator 와 WrongFixedPasswordGenerator는 사용되지 않을것이지만
    //테스트코드를 짜기 위해 Correct과 Wrong을 만들어 랜덤한 컨트롤 하기 위해 상황을 나눌 필요가 있었음.
    //결국엔 테스트코드를 짜기위해 상황을 나눴지만 , 이 변화는 User라는 클래스가 인터페이스에 의존하도록 하는 변화를 만들었음.

    //결론 : "테스트하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을수 있다"는 것을 볼 수 있게됨
    //as-is : RandomPasswordGenerator 라는 구체 클래스에 의존적
    //to-be : PasswordGenerator 라는 인터페이스에 의존하도록 해야함
    public void initPassword(PasswordGenerator passwordGenerator){

        String pwd = passwordGenerator.generatePassword();

        if (pwd.length() >= 8 && pwd.length() <= 12) {
            this.password = pwd;
        }
    }



}
