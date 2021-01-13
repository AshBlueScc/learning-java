package 基本数据类型;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 7:38 PM
 * 自动装箱与拆箱
 */
public class BoxingAndUnboxing {

    public static void main(String[] args){
        Integer i = 10; //装箱，使用valueOf()方法
        int n = i;  //拆箱,使用intValue()方法
        //关于使用什么方法，可以通过javap -c xxx.class在target文件夹下面通过反编译class文件看出来

        testInteger();

        testDouble();

        testEquals();
    }


    public static void testInteger(){
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2); //比较的是地址，故先装箱用Integer的valueOf()方法但是可以看到Integer的valueOf()方法对于-128-
        // 127之间用的是Integer的IntegerCache这个内部类的静态数组cache缓存的数据，故相等，true
        System.out.println(i3==i4);//范围之外valueOf()采用的是new一个对象出来,故不相登,false
    }

    public static void testDouble(){
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
        //Double类的valueOf方法会采用与Integer类的valueOf方法不同的实现。很简单：在某个范围内的整型数值的个数是有限的，而浮点数却不是。
    }

    //注意，Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。
    //
    //　　　　　Double、Float的valueOf方法的实现是类似的。
    //    Boolean：(全部缓存)
    //    Byte：(全部缓存)
    //    Character(<= 127缓存)
    //    Short(-128 — 127缓存)
    //    Long(-128 — 127缓存)
    //    Float(没有缓存)
    //    Doulbe(没有缓存)




    public static void testEquals(){

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
    }

    //4.Integer i = new Integer(xxx)和Integer i =xxx;这两种方式的区别:
    //第一种方式不会触发自动装箱的过程；而第二种方式会触发
    //在执行效率和资源占用上的区别。第二种方式的执行效率和资源占用在一般性情况下要优于第一种情况（注意这并不是绝对的）。
    //5.当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，而如果其中有一个操作数是表达式（即包含算术运算）
    // 则比较的是数值（即会触发自动拆箱的过程）。另外，对于包装器类型，equals方法并不会进行类型转换。
}
