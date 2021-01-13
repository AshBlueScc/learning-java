package 深入理解Java虚拟机.视频版.p33垃圾回收引用计数法;

/**
 * @author chengzhen
 * @date 2020/6/3
 * @time 下午7:59
 */
public class Main {

    private Object instance;

    public Main(){
        byte[] m = new byte[1 * 1024 * 1024];
    }

    public static void main(String[] args) {

        Main m1 = new Main();
        Main m2 = new Main();

        m1.instance = m2;
        m2.instance = m1;

        m1 = null;
        m2 = null;

        System.gc();

        //parallel

    }
}
