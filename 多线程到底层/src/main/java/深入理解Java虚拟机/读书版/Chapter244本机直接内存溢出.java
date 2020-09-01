package 深入理解Java虚拟机.读书版;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author chengzhen
 * @date 2020/8/31
 * @time 4:42 PM
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class Chapter244本机直接内存溢出 {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}

//unsafe相关参考
//1。https://www.jianshu.com/p/cda24891f9e4