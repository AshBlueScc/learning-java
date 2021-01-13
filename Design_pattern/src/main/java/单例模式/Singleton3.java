package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 14:02
 * Debug the codes and debug the world!
 */


//Holder模式
//ThreadSafe
public class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 singleton = new Singleton3();

        private SingletonHolder(){}
    }

    private Singleton3() {}

    public static Singleton3 getInstance() {
        return SingletonHolder.singleton;
    }
}
/*
Holder模式
既希望利用饿汉模式中静态变量的方便和线程安全；又希望通过懒加载规避资源浪费。Holder模式满足了这两点要求：核心仍然是静态变量，
足够方便和线程安全；通过静态的Holder类持有真正实例，间接实现了懒加载。
 */
