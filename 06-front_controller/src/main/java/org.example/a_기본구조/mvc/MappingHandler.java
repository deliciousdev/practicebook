package org.example.a_기본구조.mvc;

import org.example.a_기본구조.mvc.controller.AController;
import org.example.a_기본구조.mvc.controller.BController;
import org.example.a_기본구조.mvc.controller.Controller;
import org.example.a_기본구조.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class MappingHandler {

    private Map<String, Controller> table = new HashMap<>();

    public MappingHandler() {
        init();
    }

    public void init(){
        table.put("/", new HomeController());
        table.put("/a", new AController());
        table.put("/b", new BController());
    }

    public Controller mappingHandle(String urlPath){
        return table.get(urlPath);
    }
}
