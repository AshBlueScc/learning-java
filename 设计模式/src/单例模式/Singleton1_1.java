package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 9:09
 * Debug the codes and debug the world!
 */
//饱汉
//ThreadSafe
public class Singleton1_1 {
    private static Singleton1_1 singleton = null;

    private Singleton1_1(){}

    public synchronized static Singleton1_1 getInstance(){
        if(singleton == null){
            singleton = new Singleton1_1();
        }
        return singleton;
    }
}
/*
饱汉变种模式一：
1.好处：写起来简单，绝对线程安全。
2.坏处：并发性能差，退化到串行。单例只需要初始化一次，但是即使初始化以后，synchronized的锁也无法避开，从而getInstance方法完全变成了穿行。性能不敏感的场景建议使用。
 */
