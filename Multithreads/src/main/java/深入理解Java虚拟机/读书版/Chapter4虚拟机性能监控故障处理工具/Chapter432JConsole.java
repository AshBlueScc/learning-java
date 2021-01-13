package 深入理解Java虚拟机.读书版.Chapter4虚拟机性能监控故障处理工具;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/30
 * @time 2:05 PM
 */
public class Chapter432JConsole {
    /**
     * JVM args:-Xms100m -Xmx100m -XX:+UseSerialGC
     *
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }


    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true);
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     *  线程锁等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    /**
     * 线程死锁等待演示
     */
    static class SynAddRunable implements Runnable {
        int a, b;
        public SynAddRunable(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        fillHeap(1000);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        Object obj = new Object();
//        createLockThread(obj);

        for(int i = 0; i < 100; i++){
            new Thread(new SynAddRunable(1, 2)).start();
            new Thread(new SynAddRunable(2, 1)).start();
        }
    }
}
