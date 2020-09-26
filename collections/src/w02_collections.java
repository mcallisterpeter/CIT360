package tucket.basiccollections;

import java.util.*;

public class w02_collections {
    public static void main(String[] args) {

        System.out.println("--List--");
        List list = new ArrayList();
        list.add("1.0");
        list.add("1.1");
        list.add("1.2");
        list.add("1.3");
        list.add("1.4");
        list.add("1.5");

        for (Object str : list) {
            System.out.println((String)str);
        }
    }
}
