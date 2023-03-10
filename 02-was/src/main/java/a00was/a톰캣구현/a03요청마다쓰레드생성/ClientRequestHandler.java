package a00was.a톰캣구현.a03요청마다쓰레드생성;

import a00was.a톰캣구현.calculator.domain.Calculator;
import a00was.a톰캣구현.calculator.domain.PositiveNumber;
import a00was.a톰캣구현.http.HttpRequest;
import a00was.a톰캣구현.http.HttpResponse;
import a00was.a톰캣구현.http.QueryStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class ClientRequestHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);
    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {

        logger.info("[ClientRequestHandler] new client {} started ",Thread.currentThread().getName());
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);
            HttpResponse httpResponse = new HttpResponse(dos);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

                byte[] body = String.valueOf(result).getBytes();
//                        byte[] body = "안녕".getBytes();

                System.out.println("성공");

                httpResponse.response200Header("application/json", body.length);
                httpResponse.responseBody(body);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

