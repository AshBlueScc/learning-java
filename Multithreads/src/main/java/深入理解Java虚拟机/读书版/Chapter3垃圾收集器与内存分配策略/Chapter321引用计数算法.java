package 深入理解Java虚拟机.读书版.Chapter3垃圾收集器与内存分配策略;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 11:44 AM
 */
public class Chapter321引用计数算法 {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        Chapter321引用计数算法 objA = new Chapter321引用计数算法();
        Chapter321引用计数算法 objB = new Chapter321引用计数算法();
        objA.instance = objA;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这行发生GC, objA和objB是否能被回收?
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
