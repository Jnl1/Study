package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @date 2021/8/6
 * @time 21:15
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        ShowData data = new ShowData(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            try {
                data.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(() -> {
            try {
                data.div();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        System.out.println("5秒之后停止生产");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("时间到");
        System.out.println();
        System.out.println();
        data.changeFlag();
    }
}
