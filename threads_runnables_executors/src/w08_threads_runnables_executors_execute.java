import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class w08_threads_runnables_executors_execute {
    public static void main(String[] args) {

        //Assign Pizza Oven capacity
        int ovenCap = 4;

        //Set Pizza Oven cook time in minutes
        long ovenTime = TimeUnit.MINUTES.toMillis(1);

        //Set Oven capacity in ExecutorService
        ExecutorService myService = Executors.newFixedThreadPool(ovenCap);

        w08_threads_runnables_executors pizza1 = new w08_threads_runnables_executors("Peter", "Pepperoni", 14, ovenTime);
        w08_threads_runnables_executors pizza2 = new w08_threads_runnables_executors("Karen", "Cheese", 10, ovenTime);
        w08_threads_runnables_executors pizza3 = new w08_threads_runnables_executors("Susan", "Hawaiian", 16, ovenTime);
        w08_threads_runnables_executors pizza4 = new w08_threads_runnables_executors("Eva", "Hawaiian", 14, ovenTime);
        w08_threads_runnables_executors pizza5 = new w08_threads_runnables_executors("Gavin", "Meat Lovers", 14, ovenTime);
        w08_threads_runnables_executors pizza6 = new w08_threads_runnables_executors("Kayli", "Veggie", 12, ovenTime);
        w08_threads_runnables_executors pizza7 = new w08_threads_runnables_executors("Louise", "Works", 10, ovenTime);
        w08_threads_runnables_executors pizza8 = new w08_threads_runnables_executors("Richard", "Pepperoni", 16, ovenTime);
        w08_threads_runnables_executors pizza9 = new w08_threads_runnables_executors("Todd", "Cheese", 14, ovenTime);
        w08_threads_runnables_executors pizza10 = new w08_threads_runnables_executors("Gayle", "BBQ", 14, ovenTime);

        myService.execute(pizza1);
        myService.execute(pizza2);
        myService.execute(pizza3);
        myService.execute(pizza4);
        myService.execute(pizza5);
        myService.execute(pizza6);
        myService.execute(pizza7);
        myService.execute(pizza8);
        myService.execute(pizza9);
        myService.execute(pizza10);

        myService.shutdown();
    }
}
