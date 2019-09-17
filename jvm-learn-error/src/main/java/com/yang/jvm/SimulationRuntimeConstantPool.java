package com.yang.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Vm Args : -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @Author: Mu_Yi
 * @Date: 2019/9/17 20:26
 * @Version 1.0
 * @qq: 1411091515
 */
public class SimulationRuntimeConstantPool {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i =0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }

    }

}
