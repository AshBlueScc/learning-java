package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 9:18
 * Debug the codes and debug the world!
 */
//饱汉模式
//UnThreadSafe
public class Singleton1_2 {
    private static Singleton1_2 singleton = null;

    public int f1 = 1;
    public int f2 = 2;

    private Singleton1_2(){}

    public static Singleton1_2 getInstance() {
        //may get half object
        if(singleton == null){
            synchronized (Singleton1_2.class){
                if(singleton == null) {
                    singleton = new Singleton1_2();
                }
            }
        }
        return singleton;
    }
}
/*
饱汉模式变种二：
1.核心是DCL(Double Check Lock):线程不安全，由于指令重排序，你可能会得到“半个对象”，即部分初始化问题。
 */