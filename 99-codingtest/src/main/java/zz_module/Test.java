package zz_module;

import java.util.HashMap;

public class Test {


    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        map.put(1,10);

        Integer integer = map.get(1);
        System.out.println(integer);
        integer++;
        System.out.println(integer);

        Integer integer2 = map.get(1);
        System.out.println(integer2);
    }
}
