
public class w08_threads_runnables_executors implements Runnable {

    private String customer;
    private String type;
    private int size;
    private long cookTime;

    public w08_threads_runnables_executors( String customer, String type, int size, long cookTime) {
        this.customer = customer;
        this.type = type;
        this.size = size;
        this.cookTime = cookTime;
    }

    public void run() {
        System.out.println("\nStarting " + customer + "'s " + size + " in. " + type + " Pizza in the oven.\n");

        try{
            System.out.println("\n" + customer + "'s pizza is still cooking...\n");
            Thread.sleep(cookTime);
        } catch(InterruptedException e) {
            System.err.println(e.toString());
        }
        System.out.println("\n" + customer + "'s " + size + " in. " + type +" Pizza is done.\n");
    }
}
