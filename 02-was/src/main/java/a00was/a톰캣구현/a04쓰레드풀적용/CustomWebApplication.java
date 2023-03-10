package a00was.a톰캣구현.a04쓰레드풀적용;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplication {

    private final int port;
    private final Logger logger = LoggerFactory.getLogger(CustomWebApplication.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public CustomWebApplication(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            logger.info("[CustomWebApplicationServer] started {} port",port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ( (clientSocket= serverSocket.accept())!=null) {
                logger.info("[CustomWebApplicationServer] client connected!");

//                new Thread(new ClientRequestHandler(clientSocket)).start();//매번 쓰레드생성
                executorService.execute(new ClientRequestHandler(clientSocket));//쓰레드풀
            }
        }

    }

}

