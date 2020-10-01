
import java.util.*;

public class w03_exceptions {

    static double divValue(double numOne, double numTwo) {
        double divValue = 0;
        if(numTwo == 0) {
            throw new ArithmeticException();
        } else {
            divValue = numOne / numTwo;
            return divValue;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double fNum = 0;
        double sNum = 0;
        double myResult = 0;

        System.out.println("Enter two numbers");
        System.out.print("First Number: ");
        fNum = input.nextDouble();

        boolean noError = false;
        while (!noError) {
            try {
                while (sNum == 0) {
                    System.out.print("Second Number: ");
                    sNum = input.nextDouble();
                    if (sNum == 0) {
                        System.out.println("Cannot divide by Zero.\n" +
                                "Please re-enter your second number...");
                    }
                }
                myResult = divValue(fNum, sNum);
                noError = true;
            } catch (ArithmeticException e) {
                System.out.println("Unable to divide by zero.\n" +
                        "Please re-enter your second number...");
            }
        }

        System.out.println(fNum + " divided by  " + sNum + " = " + myResult);

    }
}
