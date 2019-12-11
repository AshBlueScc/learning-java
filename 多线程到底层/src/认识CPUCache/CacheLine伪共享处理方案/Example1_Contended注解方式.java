package 认识CPUCache.CacheLine伪共享处理方案;

/**
 * Created By ChengZhen on 2019/12/11.
 * Author: Ash
 * Date: 2019/12/11
 * Time: 11:38
 * Debug the codes and debug the world!
 */

// 属性前加上时需要加上组标签
@SuppressWarnings("restriction")
public class Example1_Contended注解方式 {
//    在JDK1.8中，新增了一种注解@sun.misc.Contended，来使各个变量在Cache line中分隔开。注意，jvm需要添加参数-XX:-RestrictContended才能开启此功能
//    用时，可以在类前或属性前加上此注释：
    @sun.misc.Contended("group1")
    int value;
    @sun.misc.Contended("group1")
    long modifyTime;
    @sun.misc.Contended("group2")
    boolean flag;
    @sun.misc.Contended("group3")
    long createTime;
    @sun.misc.Contended("group3")
    char key;

    //上面采取分组策略，三组分别用三个不同的CacheLine装载
    //group1 相关变量一起
    //group2 非相关变量一起
    //group3 初始化以后不变量一起


    // 类前加上代表整个类的每个变量都会在单独的cache line中
    @sun.misc.Contended
    @SuppressWarnings("restriction")
    public class ContendedData {
        int value;
        long modifyTime;
        boolean flag;
        long createTime;
        char key;
    }
}
