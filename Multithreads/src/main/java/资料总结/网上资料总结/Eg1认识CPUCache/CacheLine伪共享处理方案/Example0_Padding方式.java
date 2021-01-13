package 资料总结.网上资料总结.Eg1认识CPUCache.CacheLine伪共享处理方案;

/**
 * Created By ChengZhen on 2019/12/11.
 * Author: Ash
 * Date: 2019/12/11
 * Time: 11:37
 * Debug the codes and debug the world!
 */
public class Example0_Padding方式 {
//    正确的方式应该将该对象属性分组，将一起变化的放在一组，与其他属性无关的属性放到一组，将不变的属性放到一组。这样当每次对象变化时，
//    不会带动所有的属性重新加载缓存，提升了读取效率。在JDK1.8以前，我们一般是在属性间增加长整型变量来分隔每一组属性。
//    被操作的每一组属性占的字节数加上前后填充属性所占的字节数，不小于一个cache line的字节数就可以达到要求：
//    通过填充变量，使不相关的变量分开
    long a1,a2,a3,a4,a5,a6,a7,a8;//防止与前一个对象产生伪共享
    int value;
    long modifyTime;
    long b1,b2,b3,b4,b5,b6,b7,b8;//防止不相关变量伪共享;
    boolean flag;
    long c1,c2,c3,c4,c5,c6,c7,c8;//
    long createTime;
    char key;
    long d1,d2,d3,d4,d5,d6,d7,d8;//防止与下一个对象产生伪共享

}
