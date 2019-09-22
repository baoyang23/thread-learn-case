package com.yang.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  CyclicBarrier 支持一个可选的Runnable 命令,在一组线程中的最后一个线程到达之后(但是在释放之前) 该命令只在每个屏障点运行一次
 *
 * @Author: Mu_Yi
 * @Date: 2019/9/15 15:47
 * @Version 1.0
 * @qq: 1411091515
 */
public class CyclicBarrierCase {
    // 徒步
    private static int [] timeForWalk = {5,8,15};
    // 自驾游
    private static int [] timeForSelf = {1,3,4};
    // 旅游大巴
    private static int [] timeForBus = {2,4,6};

    static String nowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date())  + ":" ;
    }

    static class Tour implements Runnable {

        private int [] timeForUse;

        private CyclicBarrier cyclicBarrier;

        private String tourName;

        public Tour(int[] timeForUse, CyclicBarrier cyclicBarrier, String tourName) {
            this.timeForUse = timeForUse;
            this.cyclicBarrier = cyclicBarrier;
            this.tourName = tourName;
        }

        @Override
        public void run() {
            try{
                Thread.sleep(timeForUse[0] * 1000);
                System.out.println(nowTime() + tourName + "Reached ShenZhen");
                cyclicBarrier.await();

                Thread.sleep(timeForUse[1] * 1000);
                System.out.println(nowTime() + tourName + "Reached GuangZhou");
                cyclicBarrier.await();

                Thread.sleep(timeForUse[2] * 1000);
                System.out.println(nowTime() + tourName + "Reached ChongQing");
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println("We all are here...");
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(3,runner);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Tour(timeForWalk,barrier,"WalkTour"));
        executorService.submit(new Tour(timeForSelf,barrier,"SelfTour"));
        executorService.submit(new Tour(timeForBus,barrier,"BusTour"));

        executorService.shutdown();
    }
}
