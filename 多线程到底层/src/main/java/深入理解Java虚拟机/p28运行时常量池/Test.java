package 深入理解Java虚拟机.p28运行时常量池;

/**
 * @author chengzhen
 * @date 2020/5/31
 * @time 下午9:31
 * 参考：https://www.runoob.com/java/java-string-intern.html
 */

public class Test {

    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis()/1000);
//    Test0();



//        Test1();

//        Test2();

//        Test3();
    }

    public static void Test0(){
        //字符串的创建不在堆，而是放到常量池(StringTable:HashSet [无序，不重复])
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);

        //new 在堆内存中创建对象
        String s3 = new String("abc");

        System.out.println(s1 == s3);

        //常量池中取引用
        System.out.println(s1 == s3.intern());
    }

    public static void Test1(){
//        尽管在输出中调用intern方法并没有什么效果，但是实际上后台这个方法会做一系列的动作和操作。在调用”ab”.
//        intern()方法的时候会返回”ab”，但是这个方法会首先检查字符串池中是否有”ab”这个字符串，如果存在则返回这个字符串的引用，
//        否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
//        可以看下面一个范例：
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
//
//        得到的结果：
//        true
//        false
//        true
//        false
//        为什么会得到这样的一个结果呢？我们一步一步的分析。
//        第一、str5.equals(str3)这个结果为true，不用太多的解释，因为字符串的值的内容相同。
//        第二、str5 == str3对比的是引用的地址是否相同，由于str5采用new String方式定义的，所以地址引用一定不相等。所以结果为false。
//        第三、当str5调用intern的时候，会检查字符串池中是否含有该字符串。由于之前定义的str3已经进入字符串池中，所以会得到相同的引用。
//        第四，当str4 = str1 + str2后，str4的值也为”ab”，但是为什么这个结果会是false呢？先看Test2()：
    }

    public static void Test2(){
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);
        System.out.println(b.intern() == c);
        System.out.println(b.intern() == d);
        System.out.println(b.intern() == f);
        System.out.println(b.intern() == a.intern());
//        运行结果：
//        false
//        true
//        true
//        false
//        true
//        由运行结果可以看出来，b.intern() == a和b.intern() == c可知，采用new 创建的字符串对象不进入字符串池，
//        并且通过b.intern() == d和b.intern() == f可知，字符串相加的时候，都是静态字符串的结果会添加到字符串池，
//        如果其中含有变量（如f中的e）则不会进入字符串池中。但是字符串一旦进入字符串池中，就会先查找池中有无此对象。
//        如果有此对象，则让对象引用指向此对象。如果无此对象，则先创建此对象，再让对象引用指向此对象。
//        当研究到这个地方的时候，突然想起来经常遇到的一个比较经典的Java问题，就是对比equal和==的区别，
//        当时记得老师只是说“==”判断的是“地址”，但是并没说清楚什么时候会有地址相等的情况。现在看来，在定义变量的时候赋值，
//        如果赋值的是静态的字符串，就会执行进入字符串池的操作，如果池中含有该字符串，则返回引用。
    }

    public static void Test3(){
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(c == d);
        System.out.println(c == e);

//        运行的结果：
//        true
//        true
//        true
//        true
//        true
//        true
    }
}
