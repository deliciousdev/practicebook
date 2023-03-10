package a00was.a톰캣구현.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;

public class HttpResponse {
    private static final Logger logger = LoggerFactory.getLogger(HttpResponse.class);

    private final DataOutputStream dos;

    public HttpResponse(DataOutputStream dos) {
        this.dos = dos;
    }

    //실제 http응답 프로토콜에서 status line, header, blank line 을 합쳐서 그냥 헤더로 처리함
    public void response200Header(String contentType, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n"); //실제 프로토콜에서 status line
            dos.writeBytes("Content-Type: " + contentType + ";charset=utf-8\r\n"); //실제 프로토콜에서 header line
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n"); //실제 프로토콜에서 header line
            dos.writeBytes("\r\n");  //실제 프로토콜에서 blank line
        } catch ( IOException e) {
            logger.error(e.getMessage());
        }
    }

    //http응답에서 바디부분
    public void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
