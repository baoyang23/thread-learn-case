package com.yang.jvm.transfer;

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
 *  History         : 通过子类引用父类的静态字段,不会导致子类初始化
 *
 *</PRE>
 ***************************************************************************/
class SuperClass {

    static {
        System.out.println("SuperClass init....");
    }

    public static int value = 123;

}

class SubClass extends SuperClass{

    static {
        System.out.println("SubClasss init");
    }

}

public class NoInitialization {

    public static void main(String[] args) {

        // 通过调用 静态常量
        // System.out.println(SubClass.value);

        // 通过数组初始化也没有 调用 初始化方法
        SuperClass [] superClasses = new SuperClass[10];
    }

}
