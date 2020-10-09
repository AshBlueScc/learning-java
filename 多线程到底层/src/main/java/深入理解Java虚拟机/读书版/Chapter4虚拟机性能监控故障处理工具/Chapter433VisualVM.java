package 深入理解Java虚拟机.读书版.Chapter4虚拟机性能监控故障处理工具;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chengzhen
 * @date 2020/10/9
 * @time 11:00 AM
 */
public class Chapter433VisualVM {

    public int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        Chapter433VisualVM test = new Chapter433VisualVM();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++){
            reader.readLine();
            int a = (int)Math.round(Math.random() * 1000);
            int b = (int)Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
}


/* BTrace Script Template */
//import com.sun.btrace.annotations.*;
//        import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//    @OnMethod(
//            clazz="深入理解Java虚拟机.读书版.Chapter4虚拟机性能监控故障处理工具.Chapter433VisualVM",
//            method="add",
//            location=@Location(Kind.RETURN)
//    )
//
//    public static void func(@Self 深入理解Java虚拟机.读书版.Chapter4虚拟机性能监控故障处理工具.Chapter433VisualVM instance, int a, int b, @Return int result){
//        println("调用堆栈:");
//        jstack();
//        println(strcat("方法参数A:", str(a)));
//        println(strcat("方法参数B:", str(b)));
//        println(strcat("方法结果:", str(result)));
//    }
//}