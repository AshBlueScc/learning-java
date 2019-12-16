package chapter2_Java并发机制的底层实现原理.examples;

/**
 * Created By ChengZhen on 2019/12/16.
 * Author: Ash
 * Date: 2019/12/16
 * Time: 17:17
 * Debug the codes and debug the world!
 */
public class Test {
    private static int k = 0;
    private static int l = 0;

    public static void main(String[] args) {
        //i++,和++i的区别
        //i++先做别的再++；++i先加再作别的
        for (int i = 0; i < 10; i++) {
            k = k++;
            l = ++l;
        }
        System.out.println(k);
        System.out.println(l);
    }
}
