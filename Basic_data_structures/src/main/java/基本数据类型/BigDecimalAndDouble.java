package 基本数据类型;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chengzhen
 * @date 2020/9/3
 * @time 11:03 AM
 * bigDecimal和double的差距
 */
public class BigDecimalAndDouble {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 1.BigDecimal的精度问题
     */
    public static void test1(){
        System.out.println(new BigDecimal(0.1).toString()); // 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal("0.1").toString()); // 0.1
        System.out.println(new BigDecimal(Double.toString(0.1000000000000000055511151231257827021181583404541015625)).toString());// 0.1
        System.out.println(new BigDecimal(Double.toString(0.1)).toString()); // 0.1
    }
    /**
     * 分析一下上面代码的问题（注释的内容表示此语句的输出）

     第一行：事实上，由于二进制无法精确地表示十进制小数0.1，但是编译器读到字符串"0.1"之后，必须把它转成8个字节的double值，因此，编译器只能用一个最接近的值来代替0.1了，即0.1000000000000000055511151231257827021181583404541015625。因此，在运行时，传给BigDecimal构造函数的真正的数值是0.1000000000000000055511151231257827021181583404541015625。
     第二行：BigDecimal能够正确地把字符串转化成真正精确的浮点数。
     第三行：问题在于Double.toString会使用一定的精度来四舍五入double，然后再输出。会。Double.toString(0.1000000000000000055511151231257827021181583404541015625)输出的事实上是"0.1"，因此生成的BigDecimal表示的数也是0.1。
     第四行：基于前面的分析，事实上这一行代码等价于第三行
     */


    /**
     * 2.把double强制转化成int，难道不是扔掉小数部分吗？
     */
    public static void test2(){
        double d = 1023.99999999999999;
        int x = (int) d;
        System.out.println(new BigDecimal(d).toString()); // 1024
        System.out.println(Long.toHexString(Double.doubleToRawLongBits(d))); // 4090000000000000
        System.out.println(x); // 1024
    }

    /**
     * 原因还是在于二进制无法精确地表示某些十进制小数，因此1023.99999999999999在编译之后的double值变成了1024。
     所以，把double强制转化成int确实是扔掉小数部分，但是你写在代码中的值，并不一定是编译器生成的真正的double值。
     * 我们也可以直接打印出d的二进制形式，根据IEEE 754的规定，我们可以算出0x4090000000000000=(1024)。
     */


    /**
     * 3。构造bigDecimal时候的正确方式
     */
    public static void test3(){
        float a=57.3f;

        BigDecimal decimalA=new BigDecimal(a);

        System.out.println(decimalA);



        double b=57.3;

        BigDecimal decimalB=new BigDecimal(b);

        System.out.println(decimalB);



        double c=57.3;

        BigDecimal decimalC=new BigDecimal(Double.toString(c));

        System.out.println(decimalC);



        double d=57.3;

        BigDecimal decimalD=BigDecimal.valueOf(d);

        System.out.println(decimalD);

    }

}

/**
 *参考:
 * 1.https://www.cnblogs.com/mingforyou/p/3344489.html
 * 2.https://blog.csdn.net/lkforce/article/details/81564927
 */