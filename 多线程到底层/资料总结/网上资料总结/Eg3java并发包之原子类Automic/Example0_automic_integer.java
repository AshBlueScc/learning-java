package Eg3java并发包之原子类Automic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By ChengZhen on 2019/12/11.
 * Author: Ash
 * Date: 2019/12/11
 * Time: 14:33
 * Debug the codes and debug the world!
 */
public class Example0_automic_integer {
    //原子类其内部实现不是简单的使用synchronized，而是一个更为高效的方式CAS (compare and swap) +
    //volatile和native方法（同步的工作更多的交给了硬件），从而避免了synchronized的高开销，执行效率大为提升

    //源码分析
    //现在我们来分析一下Atomic包中AtomicInteger的源代码，其它类的源代码在原理上都比较类似。

    //有参构造函数
//    public AtomicInteger(int initialValue) {
//        value = initialValue;
//    }

//    compareAndSet方法（value的值通过内部this和valueOffset传递）
//    这个方法就是最核心的CAS操作
//    接收2个参数，一个是期望数据(expected)，一个是新数据(new)；如果atomic里面的数据和期望数据一致，则将新数据设定给atomic的数据，返回true，表明成功；否则就不设定，并返回false。
//    public final boolean compareAndSet(int expect, int update) {
//        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
//    }

//    getAndSet方法,在该方法中调用了compareAndSet方法
//    本质是get( )操作，然后做set( )操作。尽管这2个操作都是atomic，但是他们合并在一起的时候，就不是atomic
//    如果在执行if(compareAndSet(current,newValue)之前其它线程更改了value的值，那么导致value的值必定和current的值不同，compareAndSet执行失败，只能重新获取value的值，然后继续比较，直到成功。
//    public final int getAndSet(int newValue) {
//        for (;;) {
//            int current = get();
//            if (compareAndSet(current, newValue))
//                return current;
//        }
//    }

//    i++的实现
//    一般来说自增和自减都不是原子操作，其中包含有3个操作步骤：第一步，读取i；第二步，加1或减1；第三步，写回内存
//    为了实现原子性，必须在for循环中比较值value是否被修改
//    public final int getAndIncrement() {
//        for (;;) {
//            int current = get();
//            int next = current + 1;
//            if (compareAndSet(current, next))
//                return current;
//        }
//    }

//    ++i的实现
//    public final int incrementAndGet() {
//        for (;;) {
//            int current = get();
//            int next = current + 1;
//            if (compareAndSet(current, next))
//                return next;
//        }
//    }

//    实例：使用AutomicInteger实现随机数字生成器
    public class AutomicRandom {
        private AtomicInteger seed;
        private int max;

        AutomicRandom(int seed, int max) {
            this.seed = new AtomicInteger(seed);
            this.max = max;
        }
        public int nextInt(){
            while(true) {
                int s = seed.get();
                int nextSeed = calculateNet(s);
                if(seed.compareAndSet(s, nextSeed)){
                    //对比新旧数据是否一致，一致则设置
                    //新的数字成功设置到原子类对象里面
                    int remainder = s % max;
                    return remainder > 0 ? remainder : remainder + max;
                }
            }
        }

    private int calculateNet(int s) {
        Random rd = new Random();
        rd.setSeed(s);
        return rd.nextInt();
    }
}

//    总结
//    在中低程度的竞争下，原子类提供更高的伸缩性；在高强度的竞争下，锁能更好的帮助我们避免竞争。（来自《并发编程实战》）
//    所以，我们要视情况而定，若资源竞争规模不大，控制粒度较小，使用原子类比使用锁更好，能提高效率与性能

}

