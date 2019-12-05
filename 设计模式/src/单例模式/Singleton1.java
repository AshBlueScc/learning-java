package 单例模式;

/**
 * Created By ChengZhen on 2019/12/4.
 * Author: Ash
 * Date: 2019/12/4
 * Time: 18:13
 * Debug the codes and debug the world!
 */
public class Singleton1 {
    //基础饱汉
    //UnThreadSafe
    private static Singleton1 singleton1 = null;

    private Singleton1(){ }

    public static Singleton1 getInstance(){
        if(singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;

    }
}
/*
饱汉模式：
    1.好处：懒加载，启动速度更快，节省资源。一直到实例被第一次访问才需要被初始化。可读性好，建议用于单线程环境下。
    2.坏处：写起来小麻烦，线程不安全，if语句存在竞态条件
 */