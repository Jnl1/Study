package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2021/8/6
 * @time 21:15
 */
public class ShowData {
    private volatile Boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    //创建一个阻塞队列
    private BlockingQueue<String> queue;
    //通过有参构造创建指定类型
    public ShowData(BlockingQueue<String> queue) {
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }


    public void add() throws Exception{
        boolean result;
        String num = null;
        while(flag){
            num = atomicInteger.incrementAndGet()+"";
            //如果flag为true 就开始生产
            result = queue.offer(num,2L, TimeUnit.SECONDS);
            if (result){
                System.out.println(Thread.currentThread().getName() + "--生产了" + num + "一个商品");
            }else {
                System.out.println(Thread.currentThread().getName() + "--生产失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("生产任务被叫停,生产结束");
    }


    public void div() throws Exception{
        String result = null;
        while (flag){
            //如果flag为true就开始消费
           result = queue.poll(2,TimeUnit.SECONDS);
           if (null == result || "".equals(result)){
               flag = false;
               System.out.println(Thread.currentThread().getName() + "--消费失败");
               return;
           }else {
               System.out.println(Thread.currentThread().getName() + "--消费成功" + result);
           }
        }
        System.out.println("商品不再生产,停止消费");
    }

    public void changeFlag(){
        flag = false;
    }
}
