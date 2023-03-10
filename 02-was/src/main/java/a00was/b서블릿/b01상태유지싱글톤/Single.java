package a00was.b서블릿.b01상태유지싱글톤;

public class Single implements Runnable{

    private int cnt=0;

    public void increment(){
        ++cnt;
    }

    public void decrement(){
        --cnt;
    }


    @Override
    public void run() {
        this.increment();
        System.out.println(Thread.currentThread().getName() + " " + this.cnt);//1

        this.decrement();
        System.out.println(Thread.currentThread().getName() + " " + this.cnt);//0
    }
}
