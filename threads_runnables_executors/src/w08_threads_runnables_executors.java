import java.util.Random;

public class w08_threads_runnables_executors implements Runnable {

    private String name;
    private int number;
    private int sleep;
    private int rand;

    public w08_threads_runnables_executors( String name, int number, int sleep) {
        this.name = name;
        this.number = number;
        this.sleep = sleep;

        Random random = new Random();
        this.rand = random.nextInt(1000);
    }

    public void run() {
        System.out.println("Executing with these parameters: Name = " + name + " Number = "
                + number + " Sleep = " + sleep + " Rand Number = " + rand + "\n\n");

        for (int count = 1; count < rand; count++) {
            if (count % number == 0) {
                System.out.print(name + " is sleeping. ");
                try{
                    Thread.sleep(sleep);
                } catch(InterruptedException e) {
                    System.err.println(e.toString());
                }
            }
        }
        System.out.println("\n\n" + name + " is done." + "\n\n");
    }
}
