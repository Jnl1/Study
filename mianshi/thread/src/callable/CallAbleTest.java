package callable;

import java.util.concurrent.*;

/**
 * @date 2021/8/7
 * @time 10:12
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable");
        TimeUnit.SECONDS.sleep(2);
        return 1111;
    }
}
public class CallAbleTest {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();
        Integer integer = null;
        try {
            while (futureTask.isDone()){
                integer = futureTask.get();
                System.out.println(integer);
            }
            System.out.println(Thread.currentThread().getName() + "--------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
