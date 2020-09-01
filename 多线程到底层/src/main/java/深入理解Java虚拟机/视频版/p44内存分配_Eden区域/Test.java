package 深入理解Java虚拟机.视频版.p44内存分配_Eden区域;

/**
 * @author chengzhen
 * @date 2020/6/10
 * @time 下午5:53
 */
public class Test {
    public static void main(String[] args) {
        byte[] b1 = new byte[2*1024*1024];
        byte[] b2 = new byte[2*1024*1024];
        byte[] b3 = new byte[2*1024*1024];
        byte[] b4 = new byte[4*1024*1024];

        System.gc();
    }
}
