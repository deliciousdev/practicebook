package org.example.c_view_viewresolver추가.mvc;

import org.example.c_view_viewresolver추가.mvc.controller.AController;
import org.example.c_view_viewresolver추가.mvc.controller.Controller;
import org.example.c_view_viewresolver추가.mvc.controller.HomeController;
import org.example.c_view_viewresolver추가.mvc.controller.UserListController;

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
    }

    public Controller mappingHandle(MappingTableKey key){
        return table.get(key);
    }
}
