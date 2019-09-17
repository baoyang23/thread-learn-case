package com.yang.safe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/16 23:30
 * @Version 1.0
 * @qq: 1411091515
 */
public class UnSafeUseOneCase {

    // 获取Unsafe 实例
    static final   Unsafe unsafe;

    // 记录变量 state 在类中偏移值
    static final long stateOffset ;

    // 变量
    private volatile long state = 0;

    static {
        try{
            // 使用反射获取成员变量
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            // 设置可见
            field.setAccessible(true);

            // 获取该变量的值
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(UnSafeUseOneCase.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnSafeUseOneCase unSafeUseOneCase = new UnSafeUseOneCase();

        Boolean isSuccess = unsafe.compareAndSwapInt(unSafeUseOneCase,stateOffset,0,1);
        System.out.println(isSuccess);
    }
}
