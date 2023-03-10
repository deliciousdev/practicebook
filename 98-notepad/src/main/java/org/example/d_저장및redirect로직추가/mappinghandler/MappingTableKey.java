package org.example.d_저장및redirect로직추가.mappinghandler;

import org.example.d_저장및redirect로직추가.RequestMethod;

import java.util.Objects;

public class MappingTableKey {

    private final String uriPath;
    private final RequestMethod requestMethod;

    public MappingTableKey(String uriPath, RequestMethod requestMethod) {
        this.uriPath = uriPath;
        this.requestMethod = requestMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappingTableKey that = (MappingTableKey) o;
        return Objects.equals(uriPath, that.uriPath) && requestMethod == that.requestMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uriPath, requestMethod);
    }
}
