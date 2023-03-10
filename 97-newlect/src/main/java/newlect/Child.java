package newlect;

public class Child extends Parent{

    @Override
    public void func(){
        System.out.println("Child.func");
        super.func();
    }

    @Override
    public void func2() {
        System.out.println("Child.func2");
    }
}
