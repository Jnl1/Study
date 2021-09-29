package locj;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;

/**
 * @date 2021/8/8
 * @time 12:12
 */
class One implements Runnable{
    private String lockA;
    private String lockB;

    public One(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "自己持有:+" + lockA + "\t" + "尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "自己持有:" + lockB + "\t" + "尝试获取" + lockA);
            }
        }
    }
}
public class DeahLock {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new One(lockA, lockB),"AAA").start();
        new Thread(new One(lockB, lockA),"BBB").start();
    }
}
