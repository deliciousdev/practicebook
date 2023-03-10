package a00was.b서블릿.b01상태유지싱글톤;

public class Main {

    public static void main(String[] args) {
        Single single = new Single();

        Thread thread1 = new Thread(single,"Th1");
        Thread thread2 = new Thread(single,"Th2");
        Thread thread3 = new Thread(single,"Th3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
