package a00was.a톰캣구현.a04쓰레드풀적용;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        new CustomWebApplication(8080).start();
    }

}