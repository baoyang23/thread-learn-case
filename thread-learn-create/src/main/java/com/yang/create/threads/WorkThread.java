package com.yang.create.threads;

/****
 * author: BaoYang
 * data: 2023/3/15
 * desc:
 ***/
public class WorkThread implements Runnable {

    private String command;

    public WorkThread(String command) {
        this.command = command;
    }

    private void processCommand(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return this.command;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " start: Command" + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end");

    }

}
