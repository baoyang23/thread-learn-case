package com.yang.thread.pool;

import java.util.concurrent.ThreadFactory;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-25
 *
 *  Author          : Gavin
 *
 *  Purpose         : 自定义一个线程工厂
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class MySelfThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        // do something


        // 创建新线程并且返回
        return new Thread(r);
    }


}
