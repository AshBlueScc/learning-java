package 深入理解Java虚拟机.视频版.p4And5内存溢出问题分析与解决;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/5/7
 * @time 下午4:57
 */
public class Jvm {
    public static void main(String[] args) {
        List<Demo> listDemo = new ArrayList<Demo>();
        while (true){
            listDemo.add(new Demo());
        }
    }
    /**
     * 1.为了观察到内存溢出，需要运行时配置虚拟机参数
     * -XX:+HeapDumpOnOutOfMemoryError
     * -Xms20m -Xmx20m
     *
     * JConsole
     */
}
