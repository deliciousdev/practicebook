package newlect;

public class Parent {

    public void func(){
        System.out.println("Parent.func");
        this.func2();
    }

    public void func2(){
        System.out.println("Parent.func2");
    }
}
