package a00was.a톰캣구현.http;

import java.util.Objects;

public class QueryString {

    private String key;
    private String value;

    // "operand1=11&operator=*&operand2=55"

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean exists(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryString that = (QueryString) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
