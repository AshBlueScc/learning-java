package 单例模式;

/**
 * Created By ChengZhen on 2019/12/5.
 * Author: Ash
 * Date: 2019/12/5
 * Time: 14:12
 * Debug the codes and debug the world!
 */
//枚举
//ThreadSafe
public enum Singleton4 {
    SINGLETON;
}
//代码量比饿汉模式更少。但用户只能直接访问实例Singleton4.SINGLETON——事实上，这样的访问方式作为单例使用也是恰当的，只是牺牲了静态工厂方法的优点，如无法实现懒加载。