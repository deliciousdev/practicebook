package a00was.a톰캣구현.a03요청마다쓰레드생성;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomWebApplication {

    private final int port;
    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplication.class);

    public CustomWebApplication(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            logger.info("[CustomWebApplicationServer] started {} port",port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ( (clientSocket= serverSocket.accept())!=null) {//클라이언트를 기다리고 있다가 클라이언트가 오면 로직으로 진입
                logger.info("[CustomWebApplicationServer] client connected!");


                new Thread(new ClientRequestHandler(clientSocket)).start();

            }
        }

    }

}

