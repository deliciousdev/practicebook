package a00was.a톰캣구현.a01기본;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

            while ( (clientSocket= serverSocket.accept())!= null) {//클라이언트를 기다리고 있다가 클라이언트가 오면 로직으로 진입
                logger.info("[CustomWebApplicationServer] client connected!");
                // 클라이언트 소켓으로 인풋,아웃풋 스트림을 연다
                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {

                    //라인by라인 으로 읽고싶어서 인풋스트림에 버퍼리더 추가함(인풋스트림을 인풋리더로 감싸고 버퍼리더로 한번더감싼다)
                    //아웃풋 스트림도 데이터아웃풋 스트림으로 감싸줌
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    DataOutputStream dos = new DataOutputStream(out);


                    //클라이언트의 http 요청을 받아서 찍어보자
                    //톰캣이 시스템 내부적으로 이러한 http요청이 들어왔을때 파싱을 해서 스프링쪽으로 넘김
                    //개발자는 파싱된 데이터를 사용만 하면됨
                    String line;
                    while ((line = br.readLine()) != null ){
//                    while ((line = br.readLine()) != ""){
                        System.out.println(line);
                    }

                    //http 요청메시지의 첫번째줄인 Requestline 을 뽑아내서 처리하자
                    //우선 RequestLine이라는 클래스를 모델링하자(HttpMethod, path,queryString)
                }
            }
        }
    }
}
