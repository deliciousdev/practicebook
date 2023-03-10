package a00was.a톰캣구현.http;

import java.util.Objects;

public class RequestLine {

    private String method;
    private String path;
    private QueryStrings queryStrings;


    public RequestLine(String method, String path, String queryString) {
        this.method = method;
        this.path = path;
        this.queryStrings = new QueryStrings(queryString);
    }

    //   GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
    public RequestLine(String requestLine) {
        if(requestLine.equals(" ")) return;//테스트 디버깅용

        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] uriTokens = tokens[1].split("\\?");
        this.path = uriTokens[0];
        if (uriTokens.length==2) {//path와, url 에 물음표가 안들어갈 경우에만 로직이 성립하긴함
            this.queryStrings = new QueryStrings(uriTokens[1]);
        }
    }



    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String path) {
        return this.path.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(path, that.path) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, queryStrings);
    }
}
