package com.yang.create.unsafes;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/****
 * author: BaoYang
 * data: 2023/3/25
 * desc: 通过反射获取 unsafe
 ***/
public class UnSafeGet {

    static  Unsafe unsafe;
    static  long stateOffset;
    private volatile long state;

    static {
        // unsafe 的获取
        try {

            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可取
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnSafeGet.class.getDeclaredField("state"));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        UnSafeGet unSafeGet = new UnSafeGet();
        boolean sucess  = unsafe.compareAndSwapInt(unSafeGet, stateOffset, 0, 1);
        System.out.println(sucess + "---->" + unsafe.getIntVolatile(unSafeGet, stateOffset));

        boolean b = unsafe.compareAndSwapInt(unSafeGet, stateOffset, 1, 10);
        System.out.println(b + " ----> " + unsafe.getIntVolatile(unSafeGet, stateOffset));

        boolean b1 = unsafe.compareAndSwapInt(unSafeGet, stateOffset, 9, 20);
        System.out.println(b1 + " ----> " + unsafe.getIntVolatile(unSafeGet, stateOffset));

    }

}
