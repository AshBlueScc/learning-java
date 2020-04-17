package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 9:31
 * Debug the codes and debug the world!
 */
//饱汉
//ThreadSafe
public class Singleton1_3 {
    private static volatile Singleton1_3 singleton = null;

    public int f1 = 1; //触发部分初始化问题
    public int f2 = 2;

    private Singleton1_3() {}

    public static Singleton1_3 getInstance() {
        if(singleton == null) {
            synchronized (Singleton1_3.class) {
                if(singleton == null) {
                    singleton = new Singleton1_3();
                }
            }
        }
        return singleton;
    }
}
/*
部分初始化：子类的构造函数应该首先让父类的构造函数来完成把空白内存开辟为父类对象的那部分初始化工作。
多线程环境下，变种三更适用于性能敏感的场景。
1.就算是线程安全的，还有一些办法能破坏单例。
2.还有很多方式，能通过与volatile类似的方式防止部分初始化（内存屏障）
 */