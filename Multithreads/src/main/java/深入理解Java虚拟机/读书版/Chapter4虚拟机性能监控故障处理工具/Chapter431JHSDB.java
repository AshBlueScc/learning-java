package 深入理解Java虚拟机.读书版.Chapter4虚拟机性能监控故障处理工具;

/**
 * @author chengzhen
 * @date 2020/9/30
 * @time 10:46

 */
public class Chapter431JHSDB {


    /**
     * JVM args:-Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
     */
    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");  //这里设一个断点
        }
    }
    private static class ObjectHolder{}




    public static void main(String[] args) {
        Test test = new Chapter431JHSDB.Test();
        test.foo();
    }
}
/**
 * 参考:
 * 1.https://www.jianshu.com/p/92931e6466b3
 *
 */