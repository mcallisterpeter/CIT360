import java.util.*;
public class tips {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the tip tracker\n");

        String orderId = "";
        String sale = "";
        String tip = "";
        String yn = "";
        boolean done = false;
        int tracker = 1;
        List tipCollection = new ArrayList();

        System.out.println("To track your tips we will need the order id, sale amount, and tip amount.\n" +
                "The order ID must be a whole number\n" +
                "The sale amount must be a number\n" +
                "The tip amount must be a number.\n\n" +
                "LET'S START TRACKING!!");

        while (!done) {
            System.out.print("   Order ID: ");
            orderId = input.nextLine();
            while (!new int_exception(orderId).getBoolean()) {
                System.err.print("Order ID must be a whole number.\n" +
                        "Re-Enter Order ID: ");
                orderId = input.nextLine();
            }

            System.out.print("Sale Amount: ");
            sale = input.nextLine();
            while (!new double_exception(sale).getBoolean()) {
                System.err.print("Sale amount must be a number.\n" +
                        "Re-Enter Sale Amount: ");
                sale = input.nextLine();
            }

            System.out.print(" Tip Amount: ");
            tip = input.nextLine();
            while (!new double_exception(tip).getBoolean()) {
                System.err.print("Tip amount must be a number.\n" +
                        "Re-Enter Tip Amount: ");
                tip = input.nextLine();
            }

            tipCollection.add(orderId);
            tipCollection.add(sale);
            tipCollection.add(tip);

            System.out.print("Are you done?: ");
            yn = input.nextLine();
            while (!new yn_exception(yn).getBoolean()) {
                System.err.print("Input must be 'Y' or 'N'.\n" +
                        "Are you done?: ");
                yn = input.nextLine();
            }
            if (yn.equals("y") || yn.equals("Y")) {
                done = true;
            }

            tracker++;
        }


        for (Object o : tipCollection) {
            System.out.println((String) o);
        }


    }
}
