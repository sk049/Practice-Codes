package com.salil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by B0097044 on 04/07/17.
 */
public class HashMaps {
    public static void main(String args []){
         Map<String,String> map = new HashMap<>();
         map.put("a","1");
         map.put("b","2");
         map.put("c","3");
         map.put("d","4");
         map.put("e","5");
         map.put("f","6");
         HashMaps ob = new HashMaps();
         ob.printMap(map);
         map.put("h","8");
         ob.printMap(map);
        System.out.println(map.get("g"));


    }

    public void printMap(Map<String ,String> map1){
        System.out.println(map1.toString());
        map1.put("g","7");
        System.out.println(map1.toString());
    }
}
