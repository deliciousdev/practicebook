package org.example.d_저장및redirect로직추가.mappinghandler;

import org.example.d_저장및redirect로직추가.RequestMethod;
import org.example.d_저장및redirect로직추가.controller.*;

import java.util.HashMap;
import java.util.Map;

public class MappingHandler {

    private Map<MappingTableKey, Controller> table = new HashMap<>();

    public MappingHandler() {
        init();
    }

    public void init(){
        table.put(new MappingTableKey("/", RequestMethod.GET ), new HomeController());
        table.put(new MappingTableKey("/a", RequestMethod.GET ), new AController());
        table.put(new MappingTableKey("/users", RequestMethod.GET), new UserListController());
        table.put(new MappingTableKey("/users", RequestMethod.POST), new UserCreateController());
        table.put(new MappingTableKey("/user/form", RequestMethod.GET), new ForwardController());
    }

    public Controller mappingHandle(MappingTableKey key){
        return table.get(key);
    }
}
