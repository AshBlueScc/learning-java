package 资料总结.网上资料总结.Eg2Volatile内存屏障;

/**
 * Created By ChengZhen on 2019/12/10.
 * Author: Ash
 * Date: 2019/12/10
 * Time: 9:44
 * Debug the codes and debug the world!
 */
public class OutofOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args)
            throws InterruptedException {
        for(int i=0; i < 1000000; i++) {
            new OutofOrderExecution().execution();
        }

    }

    public void execution() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        t2.start();
        t1.start();
        t2.join();
        t1.join();

        if(x== 0&&y==0){
            System.out.println("(" + x + "," + y + ")");
        }

        if(x== 1&&y==0){
            System.out.println("(" + x + "," + y + ")");
        }

    }
}

//参考的题主说可能会出现（0，0）但是经我测试只有（0，1）（1，0）（1，1）这三种情况且（1，1）最多
//但是从逻辑上分析的确可能出现这样的情况(处理器中写缓冲区的存在)