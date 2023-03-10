package org.example.z_연습.mappinghandler;

import org.example.z_연습.RequestMethod;
import org.example.z_연습.controller.*;

import java.util.HashMap;
import java.util.Map;

public class MappingHandler {

    private Map<MappingTableKey, Controller> table = new HashMap<>();

    public MappingHandler() {
        init();
    }

    public void init(){
        table.put(new MappingTableKey("/", RequestMethod.GET ), new HomeController());
        table.put(new MappingTableKey("/myuri", RequestMethod.GET), new MyURIController());
        table.put(new MappingTableKey("/myuri", RequestMethod.POST), new MyURIController2());
    }

    public Controller mappingHandle(MappingTableKey key){
        return table.get(key);
    }
}
