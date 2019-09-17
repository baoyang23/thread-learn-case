package com.yang.jvm;

/**
 *  VM Args : -Xss128k
 * @Author: Mu_Yi
 * @Date: 2019/9/17 20:20
 * @Version 1.0
 * @qq: 1411091515
 */
public class SimulationJavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args)  throws Throwable {
        SimulationJavaVMStackSOF simulationJavaVMStackSOF = new SimulationJavaVMStackSOF();
        try{
            simulationJavaVMStackSOF.stackLeak();
        } catch (Throwable e){
            System.out.println("stack length : " + simulationJavaVMStackSOF.stackLength);
            throw  e;
        }
    }
}
