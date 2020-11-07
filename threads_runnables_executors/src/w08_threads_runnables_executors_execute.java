import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class w08_threads_runnables_executors_execute {
    public static void main(String[] args) {
        ExecutorService myService = Executors.newFixedThreadPool(3);

        w08_threads_runnables_executors ds1 = new w08_threads_runnables_executors("Peter", 32, 1000);
        w08_threads_runnables_executors ds2 = new w08_threads_runnables_executors("Todd", 42, 500);
        w08_threads_runnables_executors ds3 = new w08_threads_runnables_executors("Richard", 38, 250);
        w08_threads_runnables_executors ds4 = new w08_threads_runnables_executors("Karen", 45, 100);
        w08_threads_runnables_executors ds5 = new w08_threads_runnables_executors("Louise", 36, 50);

        myService.execute(ds1);
        myService.execute(ds2);
        myService.execute(ds3);
        myService.execute(ds4);
        myService.execute(ds5);

        myService.shutdown();
    }
}
