package com.yang.create;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         :  终止线程执行的方法
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ThreadInterruptCase extends Thread {

    static int result = 0;

    public ThreadInterruptCase(String name){ super(name);}

    /**
     *
     * 主线程执行
     * 计算线程Gavin开始计算....
     * 2000 毫秒后 : 0
     * 计算线程Gavin被中断,结束
     *  可以看出线程被中断后;run方法后面的二句代码是没有执行的.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程执行");
        Thread t = new ThreadInterruptCase("计算线程Gavin");
        t.start();
        try{
            long start = System.nanoTime();
            t.join(2000);
            long end = System.nanoTime();
            t.interrupt();
            System.out.println((end - start) / 1000000 + " 毫秒后 : " + result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        System.out.println(this.getName() + "开始计算....");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
/*            if(Thread.isInterrupted()){
                System.out.println(this.getName() + "被中断 ===> Specical log.");
            }*/

            System.out.println(this.getName() + "被中断,结束");
            return;
            // e.printStackTrace();
        }
        if(this.isInterrupted()){
            System.out.println(this.getName() + "被中断");
        }

        result = (int) (Math.random() * 10000);
        System.out.println(this.getName() + "结束计算");
    }
}
