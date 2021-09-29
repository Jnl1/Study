package com;

import java.util.concurrent.*;

/**
 * @date 2021/8/6
 * @time 9:26
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        //AbortPolicy 如果请求任务超出线程池的最大线程数量就会抛出异常
        //CallerRunsPolicy 如果轻轻任务超出线程池的最大线程数那么就会将某些任务会提到调用者
        //DiscardOldestPolicy 抛弃队列中等待最久的任务,然后把当前任务加入队列尝试再次请求提交到当前任务
        //DiscardPolicy 多余任务抛弃
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "提交任务");
                });
            }
        } finally {
            threadPool.shutdown();
        }
        //如果配置线程池的线程数量
        //1.CPU密集: CPU的核数 + 1
        //2.IO密集: CPU核数 * 2
        //2.IO密集:大量的IO,大量的阻塞 CPU核数/1-阻塞系数  一般系数都是(0.8~0.9)

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private static void threadExecutor() {
        //一池固定线程
        ExecutorService es1 = Executors.newFixedThreadPool(1);
        //一池一线程
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        //一池N线程
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 100; i++) {
                es.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
