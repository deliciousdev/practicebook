package a00was.a톰캣구현.a02메인쓰레드;

import a00was.a톰캣구현.calculator.domain.Calculator;
import a00was.a톰캣구현.calculator.domain.PositiveNumber;
import a00was.a톰캣구현.http.HttpRequest;
import a00was.a톰캣구현.http.HttpResponse;
import a00was.a톰캣구현.http.QueryStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

            while ( (clientSocket= serverSocket.accept())!= null) {//클라이언트를 기다리고 있다가 클라이언트가 오면 로직으로 진입
                logger.info("[CustomWebApplicationServer] client connected!");


                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    HttpRequest httpRequest = new HttpRequest(br);
                    HttpResponse httpResponse = new HttpResponse(dos);

                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                        QueryStrings queryStrings= httpRequest.getQueryStrings();

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

                        byte[] body = String.valueOf(result).getBytes();
//                        byte[] body = "안녕".getBytes();

                        httpResponse.response200Header("application/json", body.length);
                        httpResponse.responseBody(body);
                        System.out.println("처리");

                    }
                }
            }
        }


    }

}
