package org.example.d_저장및redirect로직추가.repository;

import org.example.d_저장및redirect로직추가.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserMemoryRepository {

    private static Map<String, User> store= new HashMap<>();

    public static void save(User user) {
        store.put(user.getUserId(), user);
    }

    public static Collection<User> findAll(){ //원래는 이런식으로 하면안됨
        return store.values();
    }
}
