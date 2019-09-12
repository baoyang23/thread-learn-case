package com.yang.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class CreateThreadFunctionThree {

    /**
     * newFixedThreadPool : 创建一个可重用固定线程数的线程池,以共享无界队列的方式来运行这些线程
     * defaultThreadFactory : 返回用于创建线程的默认线程工厂.
     * newCachedThreadPool : 创建一个可根据需要创建新线程的线程池
     * newScheduledThreadPool : 创建一个新线程,它可安排在给定延迟后运行命令或者定期执行
     *  Function :
     *     execute : 在未来的某个时间执行给定的命令。该命令可能在新的线程,已入池的线程或者正调用的线程中执行.
     *     shutdown : 启动一次顺序关闭.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception  {

        ExecutorService service = Executors.newFixedThreadPool(2);
        // Executors.newScheduledThreadPool();

        for(int index=0;index < 100;index++){
            Runner runner = new Runner(index);
            service.execute(runner);
        }
        service.shutdown();
    }


    /**
     * 线程 : pool-1-thread-1(目标对象0) : Sleep :271ms
     * 线程 : pool-1-thread-2(目标对象1) : Sleep :930ms
     * 线程 : pool-1-thread-1(目标对象2) : Sleep :202ms
     * 线程 : pool-1-thread-1(目标对象3) : Sleep :843ms
     * 线程 : pool-1-thread-2(目标对象4) : Sleep :696ms
     * 线程 : pool-1-thread-1(目标对象5) : Sleep :879ms
     * 线程 : pool-1-thread-2(目标对象6) : Sleep :393ms
     * 线程 : pool-1-thread-2(目标对象7) : Sleep :576ms
     *  .......
     *  可以看出线程池只生产出来了二个线程
     */

    static class Runner implements Runnable {

        int index;

        public Runner(int index) {
            this.index = index;
        }

        @Override
        public void run() {

            long time = (long) (Math.random() * 1000);
            System.out.println("线程 : " + Thread.currentThread().getName() + "(目标对象" + index + ")" + " : Sleep :" + time + "ms");
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
