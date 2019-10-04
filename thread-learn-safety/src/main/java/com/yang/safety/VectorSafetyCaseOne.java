package com.yang.safety;

import java.util.Vector;

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
public class VectorSafetyCaseOne {


    private static Vector<Integer> vector = new Vector<>();


    public static void main(String[] args) {

        while (true){

            for(int i=0;i<10;i++){
                vector.add(i);
            }

            Thread removeThread = new Thread(()-> {
                for(int i=0;i<vector.size();i++){
                    vector.remove(i);
                }
            });

            Thread printThread = new Thread(() -> {
                for(int i=0;i<vector.size();i++){
                    System.out.println(vector.get(i));
                }
            });


            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 30) {}
        }

    }

}
