package com.yang.jvm.func;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-7
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class SomeFunctionMethod {

    private int m;

    public  int inc(){

        // return m + 1;
        int x;
        try {
            x = 1;
            int ccc = 1/0;
            return x;
        } catch (Exception e){
            x = 2;
            return x;
        } finally {
            x = 3;
        }

    }


    public void onlyMe(Object f){
        synchronized (f){
            inc();
        }
    }

}
