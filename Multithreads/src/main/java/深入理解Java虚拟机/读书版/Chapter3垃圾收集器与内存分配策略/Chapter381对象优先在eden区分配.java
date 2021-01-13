package 深入理解Java虚拟机.读书版.Chapter3垃圾收集器与内存分配策略;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/24
 * @time 4:08 PM
 * Chapter381对象优先在eden区分配
 */
public class Chapter381对象优先在eden区分配 {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC
     */

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];   //出现一次Minor GC
    }

    /**
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     */

    public static void testPretenureSizeThreshold(){
        byte[] allocation1;
        allocation1 = new byte[4 * _1MB];
    }

    /**
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:MaxTenuringThreshold=1
     */

    public static void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 7];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];

        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testAllocation();
//        testPretenureSizeThreshold();
        testTenuringThreshold();
//        testTenuringThreshold2();
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
//        System.out.println(System.getProperty("java.vm.name"));
    }
}
