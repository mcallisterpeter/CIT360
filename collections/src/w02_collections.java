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
        list.add("1.2");

        for (Object str : list) {
            System.out.println((String)str);
        }

        System.out.println("--Set--");
        Set set = new TreeSet();
        set.add("1.0");
        set.add("1.1");
        set.add("1.2");
        set.add("1.3");
        set.add("1.4");
        set.add("1.5");
        set.add("1.2");

        for (Object str : set) {
            System.out.println((String)str);
        }

        System.out.println("--Queue--");
        Queue queue = new PriorityQueue();
        queue.add("1.0");
        queue.add("1.1");
        queue.add("1.2");
        queue.add("1.3");
        queue.add("1.4");
        queue.add("1.5");
        queue.add("1.2");

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(queue.poll());
        }

        System.out.println("--Map--");
        Map map = new HashMap();
        map.put(1, "1.0");
        map.put(2, "1.1");
        map.put(3, "1.2");
        map.put(4, "1.3");
        map.put(5, "1.4");
        map.put(6, "1.5");
        map.put(7, "1.2");

        for (int i = 1; i <= 7; i++) {
            String result = (String)map.get(i);
            System.out.println(result);
        }

    }
}
