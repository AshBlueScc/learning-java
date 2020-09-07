package 深入理解Java虚拟机.读书版.Chapter2Java内存区域与内存溢出异常;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengzhen
 * @date 2020/8/14
 * @time 2:48 PM
 *
 * JDK6运行
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 *
 * JDK7+
 * VM Args: -Xms6M
 */
public class Chapter243方法区和运行时常量池溢出 {

    public static void main(String[] args) {
//        test();
//        test1();
        test3();
    }

    public static void test(){
        //使用Set保持着常量池引用，避免Full, GC回收常量池行为
        Set<String> set = new HashSet<>();
        //在short范围内足以让6MB的PermSize产生OOM
        short i = 0;
        while(true){
            set.add(String.valueOf(i++).intern());
        }
    }

    public static void test1(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());

        /**
         * 1。JDK6, 返回两个false, 是因为intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池中存储，返回永久代的常量池中这个字符串的引用，而由StringBuilder创建的字符串对象实例在
         * java堆上，必然不可能是同一个引用
         * 2。而JDK7（以及其他部分虚拟机，例如JRockit）的intern()方法实现已经不需要再拷贝字符串的实例到永久代了，字符串常量池已经移到java堆中，只记录首次出现的引用即可，因此intern()返回的引用和
         * StringBuilder创建的字符串实例就是同一个。"java"这个字符串在执行StringBuilder.toString()之前就已经出现过了，字符串常量池中已经有它的引用，不符合intern()"首次遇到"的原则。
         */
    }


    /**
     * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void test3(){
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{}

}

/**
 * 1。运行时常量池是方法区的一部分，HotSpot从JDK7开始逐步"去永久代"的计划，并在JDK8开始完全用元空间代替永久代。
 * 2.String:intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用；
 * 否则，会将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。
 * 3。在JDK6或更早之前的HotSpot虚拟机中，我们可以通过-XX: PermSize和-XX: MaxPermSize限制永久代大小，即可间接限制其中常量池的容量
 * 4.自jdk7起，原本存放在永久代的字符串常量池被移至Java堆之中
 *
 *
 */
