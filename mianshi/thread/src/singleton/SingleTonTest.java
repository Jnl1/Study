package singleton;

import java.util.concurrent.*;

/**
 * @date 2021/8/6
 * @time 19:29
 */

enum Singleton{
    INSTANCE_TWO
}
class Test{
    public static final Test INSTANCE = new Test();
    private Test(){


    }
}

class SingleTonTest1{

    private static  SingleTonTest1 INSTANCE_1;

    private SingleTonTest1() {
    }
    public static SingleTonTest1 method(){
        if (INSTANCE_1 == null){
            synchronized (SingleTonTest1.class){
                if (INSTANCE_1 == null){

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE_1 = new SingleTonTest1();
                    return INSTANCE_1;
                }
            }
        }
        return INSTANCE_1;
    }
}
public class SingleTonTest {
    public static void main(String[] args) {
        
        Test test = Test.INSTANCE;
        System.out.println(test);
        Singleton instanceTwo = Singleton.INSTANCE_TWO;
        System.out.println();
        ExecutorService service = new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + SingleTonTest1.method());
            });
        }
        System.out.println("llll");
    }
}
