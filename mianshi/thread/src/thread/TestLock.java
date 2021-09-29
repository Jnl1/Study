package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @date 2021/8/6
 * @time 11:37
 */
class ShowData {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int num = 0;

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " -> " + num);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " -> " + num);
            condition.signal();
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
public class TestLock {
    public static void main(String[] args) {
        ShowData showData = new ShowData();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                showData.increment();
            }
        },"AA").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                showData.decrement();
            }
        },"BB").start();
    }
}
