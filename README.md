#      记录个人学习Java多线程代码



**代码的积累和个人思考才是对自己正好的成长。**



thread-learn-case 是一个父项目,下面多个子项目用于分类很好。

------



thread-learn-create 是父项目下的一个子项目



| 类名字                                    | 简介                                     |
| ----------------------------------------- | ---------------------------------------- |
| com.yang.create.CreateThreadFunctionOne   | 继承Thread 实现run()方法来实现           |
| com.yang.create.CreateThreadFunctionTwo   | 实现Runnable接口,并且重写run()方法来实现 |
| com.yang.create.CreateThreadFunctionThree | 使用线程池来跑线程.execute()方法         |
| com.yang.create.ThreadSleepCase           | 使用线程睡眠Api                          |
| com.yang.create.ThreadJoinCase            | 使用线程加入Join() appi                  |
| com.yang.create.ThreadInterruptCase       | 线程中断的使用                           |



------

thread-learn-safety

| com.yang.safety.BankAccount    | 说明线程干扰的问题;如果去掉synchronized的话,就可以看到很明显的现象 |
| ------------------------------ | ------------------------------------------------------------ |
| com.yang.safety.SequenceNumber | ThreadLocal的使用说明                                        |
|                                |                                                              |
|                                |                                                              |

------
thread-learn-pool 线程池的基本使用
