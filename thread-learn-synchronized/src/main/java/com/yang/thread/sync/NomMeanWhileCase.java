package com.yang.thread.sync;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-21
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class NomMeanWhileCase {


    public void runThread(){

        Thread t1 = new Thread(() -> {
            LoclClass.sMethodA();
        });

        Thread t2 = new Thread((() -> {
            LoclClass.sMethodB();
        }));

        t1.start();
        t2.start();

    }

    public static void main(String[] args) {

        NomMeanWhileCase nomMeanWhileCase = new NomMeanWhileCase();
        nomMeanWhileCase.runThread();

    }
}

class LoclClass {

    public static synchronized void sMethodA(){
        try{
            for(int i = 0;i < 5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : sMethodA");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized void sMethodB(){
        try{
            for(int i = 0;i < 5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : sMethodB");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}