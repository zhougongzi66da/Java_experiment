package Experiment_4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    private int tickets=100;
    private Object obj=new Object();
    private Lock lock=new ReentrantLock();//Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化


    //方法一：使用synchronized实现多线程
/*
        @Override
    public void run() {
            while (true) {
                try {
                    Thread.sleep(100);//让每个线程均有机会被执行，模拟真实卖票场景
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);//模拟出票时系统反应时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                        tickets--;
                    }
                }
            }
        }
*/


    //方法二：使用lock锁实现多线程
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);//让每个线程均有机会被执行，模拟真实卖票场景
                lock.lock();
                if(tickets>0){
                    Thread.sleep(100);//模拟出票时系统反应时间
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
                    tickets--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
