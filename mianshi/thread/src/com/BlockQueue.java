package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @date 2021/8/6
 * @time 10:43
 */
public class BlockQueue {
    public static void main(String[] args) {
        //创建一个数组的阻塞队列,并且把边界设置为3
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
