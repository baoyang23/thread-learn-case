package com.yang.keyword;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-9
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class YangInstanceofLearn {

    public static void main(String[] args) {

        Object hello = "hello";
        System.out.println(" 是否是字符类型的判断 : " + (hello instanceof String));
        System.out.println(" 是否是Object类型的判断 : "+ (hello instanceof Object));
        System.out.println(" 是否是Math类型的判断 : " + (hello instanceof Math));
        System.out.println(" 是否是Comparable类型的判断 : " + (hello instanceof Comparable));

        BaseClass baseClass = new BaseClass();
        SubClass subClass = new SubClass();
        System.out.println(subClass instanceof BaseClass);
    }
}

class BaseClass {}

class SubClass extends BaseClass{}
