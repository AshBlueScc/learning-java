package 深入理解Java虚拟机.读书版.Chapter2Java内存区域与内存溢出异常;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/8/10
 * @time 下午4:37
 *
 *-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * VM Args: -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 */
public class Chapter241堆溢出 {

    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }



}
