package a00was.b서블릿.b02동기화된싱글톤;

public class Single implements Runnable{

    private Integer cnt=0;

    public void increment(){
        ++cnt;
    }

    public void decrement(){
        --cnt;
    }


    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println(Thread.currentThread().getName() + " " + this.cnt);//1

            this.decrement();
            System.out.println(Thread.currentThread().getName() + " " + this.cnt);//0
        }
    }
}
