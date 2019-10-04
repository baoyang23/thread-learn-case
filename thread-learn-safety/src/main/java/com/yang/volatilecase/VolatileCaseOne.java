package com.yang.volatilecase;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-4
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class VolatileCaseOne {

    private static volatile int race = 0;

    public static void addRace(){
        race ++;
    }

    public static final int threadNumber = 20;

    public static void main(String[] args) {

        Thread [] threadArr = new Thread[threadNumber];
        for(int i=0;i<threadNumber;i++){
            threadArr[i] = new Thread(/*() -> {
                for(int j=0;j<10000;j++){
                    addRace();
                }
            }*/new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        addRace();
                    }
                }
            });

            threadArr[i].start();
        }

/*        while (Thread.activeCount() > 1){
            Thread.yield();
        }*/

        System.out.println(" 参数race 的值 :  " + race);
    }

}
