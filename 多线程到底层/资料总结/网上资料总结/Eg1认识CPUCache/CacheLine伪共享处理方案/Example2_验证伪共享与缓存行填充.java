package Eg1认识CPUCache.CacheLine伪共享处理方案;

import java.util.concurrent.CountDownLatch;

/**
 * Created By ChengZhen on 2019/12/11.
 * Author: Ash
 * Date: 2019/12/11
 * Time: 15:31
 * Debug the codes and debug the world!
 */
public class Example2_验证伪共享与缓存行填充 {

    /**
     * 数组保存了VolatileLongPadding，其中数组中一个long类型保存数组长度，算上
     * 自身long类型value，需要再填充6个long类型，就能将数组中的对象填充满一个 缓存行。
     * 注意：这里使用继承的方式实现缓存行对齐，因为Java7编译器会优化无效的字段。
     */

    static class VolatileLong extends VolatileLongPadding {
        //实际操作的值
        public volatile long value = 0L;
    }

//    4个线程分别操作长度为4的数组的每一个对象值。
//    当使用了缓存行填充时，每个数组内对象都存储在不同的缓存行，线程操作时不存在伪共享问题，也不需要进行缓存行写竞争
    public static class FlashSharing implements Runnable {

        //线程个数
        public static int NUM_THREADS = 4;
        //循环修改数组中数据的次数
        public final static long ITRATIONS = 500L * 1000L * 1000L;
        //数组下标
        private final int arrayIndex;
        //操作的数组
        private static VolatileLong[] longs;

        private static final CountDownLatch cd1 = new CountDownLatch(NUM_THREADS);

        public FlashSharing(final int arrayIndex) {
            this.arrayIndex = arrayIndex;
        }

        public static void main(final String[] args) throws Exception {
            Thread.sleep(10000);
            System.out.println("starting...");
            //初始化数组
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.nanoTime();
            runTest();
            System.out.println("duration = " + (System.nanoTime() - start));
        }

        private static void runTest() throws InterruptedException {
            //初始化线程组
            Thread[] threads = new Thread[NUM_THREADS];
            for (int i = 0; i < threads.length; i ++) {
                threads[i] = new Thread(new FlashSharing(i));
            }
            //开始运行所有线程
            for (Thread t : threads) {
                t.start();
            }
            //主线程阻塞直到所有子线程结束
            cd1.await();
        }

        @Override
        public void run() {
            //多线程情况下持续修改数组中某一个volatile值
            long i = ITRATIONS + 1;
            while(0 != --i){
                longs[arrayIndex].value = i;
            }
            cd1.countDown();
        }
    }
}

class VolatileLongPadding {
    // 如果不需要填充，只需要注释掉这段代码即可
    public volatile long p1, p2, p3, p4, p5, p6;
}
//填充耗时：5980881600 ns
//不填充耗时：17215170100 ns

//总结
// 当多个线程同时对共享的缓存行进行写操作的时候，因为缓存系统自身的缓存一致性原则，会引发伪共享问题，解决的常用办法是将共享
//        变量根据缓存行大小进行补充对齐，使其加载到缓存时能够独享缓存行，避免与其他共享变量存储在同一个缓存行。


//典型的以空间换时间