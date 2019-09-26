package com.yang.thread.pool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-25
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class PoolThreadSimple {

    static {
        BasicConfigurator.configure();
    }

    private static class ThreadRunnable implements Runnable {

        private static Log LOGGER = LogFactory.getLog(ThreadRunnable.class);

        private Integer index;

        public ThreadRunnable(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public void run() {

            Thread currentThread = Thread.currentThread();
            LOGGER.info("线程 : " + currentThread.getId() + " 中的任务 : ( " + this.index + ") 开始执行 ====> ");
            synchronized (currentThread) {
                try {
                    currentThread.wait(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LOGGER.error(e.getMessage(),e);
                }
            }

            LOGGER.info("线程 : " + currentThread.getId() + " 中的任务 : (" + this.index + " )执行完毕");
        }
    }

    public static void main(String[] args) throws Exception {

        /**
         * corePoolSize : 核心线程数;线程池初始化的时候,就会有这么大
         * maximumPoolSize : 线程中最大的线程数
         * keepAliveTime : 如果当前线程数池中线程数大于corePoolSize.多余的线程就会在,在KeepAlive时间后如果还没新的线程任务指派给他,它就会被回收啊.
         * unit : keepAliveTime的单位
         * workQueue : 等待队列
         */
        ThreadPoolExecutor poolExecutor =  new ThreadPoolExecutor(5,10,1,
                TimeUnit.MINUTES,new SynchronousQueue<Runnable>());

        for(int index = 0; index < 10;index++){
            poolExecutor.submit(new PoolThreadSimple.ThreadRunnable(index));
        }

        // 只是保证main函数不会退出
        synchronized (poolExecutor){
            poolExecutor.wait();
        }
    }
}
