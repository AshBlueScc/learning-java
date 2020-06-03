package 深入理解Java虚拟机.p24Java内存区域_Java虚拟机栈;

/**
 * @author chengzhen
 * @date 2020/5/31
 * @time 下午8:27
 */
public class Test {

    public static void test(){
        System.out.println("方法执行中...");
        test();
    }

    //模拟出现StackOverflowError错误
    public static void main(String[] args) {
        new Test().test();
    }
}
