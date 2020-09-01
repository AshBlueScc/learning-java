package 深入理解Java虚拟机.读书版;

/**
 * @author chengzhen
 * @date 2020/8/11
 * @time 上午10:15
 *
 * VM Args: -Xss128k
 */
public class Chapter242虚拟机栈和本地方法栈 {
    private static int stackLength = 0;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void statckLeak2(){
        long unused1, unused2, unused3, unused4, unused5, unused6;  //多占局部变量表空间
        stackLength ++;
        statckLeak2();
        unused1=unused2=unused3=unused4=unused5=unused6=0;
    }

    /**
     * VM Args: -Xss2M
     * 内存溢出异常
     */
    public static void dontStop(){
        while(true){ }
    }

    public static void statckLeak3(){
        while(true){
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run(){
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        Chapter242虚拟机栈和本地方法栈 oom = new Chapter242虚拟机栈和本地方法栈();
        try {
//            oom.stackLeak();
            statckLeak2();
//            statckLeak3();
        } catch (Throwable e) {
            System.out.println("stack length:" + stackLength);
            throw e;
        }
    }


}

/**
 *  1。-Xoss参数(设置本地方法栈大小)虽然存在，但实际上是没有任何效果的，栈容量只能由-Xss参数来设定
 *  2。虚拟机栈和本地方法栈，存在的两种异常:
 *      2.1:如果线程请求的栈深度大于虚拟机所允许的最大深度，会抛出StackOverflowError异常
 *      2.2:如果虚拟机的栈内存允许动态扩展，当扩展栈容量无法申请到足够的内存时，会抛出OurOfMemoryError异常
 *  3.实验结果表明：不管是栈帧容量太大还是虚拟机栈容量太小，当心的栈帧内存无法分配的时候hotSpot虚拟机都会抛出stackOverFlowError异常
 *
 **/