package Volatile内存屏障;

/**
 * Created By ChengZhen on 2019/12/4.
 * Author: Ash
 * Date: 2019/12/4
 * Time: 17:24
 * Debug the codes and debug the world!
 */
/*
volatile关键字的作用、原理 是轻量级的synchronized,它在多处理器开发中保证了共享变量的“可见性”。
可见性：当一个线程修改一个变量时，另外一个线程能读到这个修改的值。volatile变量修饰符修饰的变量不会引起线程上下文的切换和调度。

volatile定义：Java编程语言允许线程访问共享变量，为了确保共享变量能被准确和一致的更新，线程应该确保通过排他锁获得这个变量。如果一个字段
被声明称volatile，Java线程内存模型确保所有线程看到这个变量的值是一致的。
 */
public class Volatile {

}



/*
References:
1.https://www.jianshu.com/p/64240319ed60
2.https://blog.csdn.net/maqingbin8888/article/details/84784874

 */