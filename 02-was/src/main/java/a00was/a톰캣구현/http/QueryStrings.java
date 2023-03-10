package a00was.a톰캣구현.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QueryStrings {

    List<QueryString> queryStringList = new ArrayList();


    //   "operand1=11&operator=*&operand2=55"
    public QueryStrings(String queryStringLine) {

        String[] token = queryStringLine.split("&");
        Arrays.stream(token)
                .forEach(singleKeyValue -> {
                            String[] split = singleKeyValue.split("=");
                            if (split.length != 2) {
                                throw new IllegalArgumentException("value가 빠진것이 있습니다");
                            }
                            queryStringList.add(new QueryString(split[0], split[1]));
                        }
                );
    }

    public String getValue(String key) {
        return queryStringList.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryStrings that = (QueryStrings) o;
        return Objects.equals(queryStringList, that.queryStringList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryStringList);
    }
}
