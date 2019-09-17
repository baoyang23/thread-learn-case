package com.yang.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *  模拟Java 溢出
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  VM Args : -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * @Author: Mu_Yi
 * @Date: 2019/9/17 20:11
 * @Version 1.0
 * @qq: 1411091515
 */
public class SimulationOutOfMemoryError {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();

        while (true){
            oomObjectList.add(new OOMObject());
        }

    }


}
