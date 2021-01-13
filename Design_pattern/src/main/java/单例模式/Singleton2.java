package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 9:47
 * Debug the codes and debug the world!
 */
//饿汉
//ThreadSafe
public class Singleton2 {
    private static final Singleton2 singleton = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance() {
        return singleton;
    }
}
/*
饿汉模式：
1.好处：天生的线程安全（得益于类的加载机制），写起来简单，用起来没有延迟
2.坏处：有可能造成资源浪费（类加载后一直不用）
单线程环境下饱汉模式和饿汉模式在性能上没有
 */