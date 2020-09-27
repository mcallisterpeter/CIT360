import java.util.*;

public class w02_collections {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Example of a List Collection
        List list = new ArrayList();
        System.out.println("--List Example--");
        System.out.println("Please enter five words to be saved in the List Collection");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter a word: ");
            list.add(input.nextLine());
        }

        System.out.println("Here are the words you entered in the order that you entered them:");
        for (Object str : list) {
            System.out.println((String)str);
        }

        //Example of a Set Collection
        Set set = new TreeSet();
        System.out.println("--Set Example--");
        System.out.println("Please enter five words to be saved in the Set Collection.\n" +
                "Hint, try entering the same word twice.");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter a word: ");
            set.add(input.nextLine());
        }

        System.out.println("Here are the words you entered in alphabetical order.\n" +
                "Note, any words you entered twice only show up once:");
        for (Object str : set) {
            System.out.println((String)str);
        }

        //Example of a Queue Collection
        Queue queue = new PriorityQueue();
        System.out.println("--Queue Example--");
        System.out.println("Please enter five words to be saved in the Queue Collection.");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter a word: ");
            queue.add(input.nextLine());
        }

        System.out.println("Here are the words you entered in alphabetical order.");
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(queue.poll());
        }

        //Example of a Map Collection
        Map map = new HashMap();
        System.out.println("--Map Example--");
        System.out.println("Please enter five words to be saved in the Map Collection.\n" +
                "This time you have the ability to choose what order the array outputs.\n" +
                "Enter first the order, between 1 and 5, and then enter the word.\n" +
                "Note, if you type the same order number twice, the first word of that\n" +
                "order number will be replaced.");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter the order number: ");
            int myOrder = input.nextInt();
            input.nextLine();
            System.out.print("Enter a word: ");
            String myWord = input.nextLine();
            System.out.println(myOrder + " " + myWord);
            map.put(myOrder, myWord);
        }

        System.out.println("Here are the words you entered in the order you specified.");
        for (int i = 1; i <= 5; i++) {
            String result = (String)map.get(i);
            System.out.println(result);
        }

    }
}
