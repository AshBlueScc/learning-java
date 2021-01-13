package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术.proxy;

import 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术.UserService;
import 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 5:36 PM
 */
public class JDKProxyFactory implements InvocationHandler{

    //代理的目标对象
    private Object targetObject;
    //实力工厂返回一个目标对象的代理对象
    public Object createProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        /**
         * 第一个参数设置代码使用的类装载器，一般采用跟目标相同的类装载器
         * 第二个参数设置代理类实现的接口，所以要求代理的目标对象必须实现一个类
         * 第三个参数设置回调对象，当代理对象的方法被调用时，会委派给该参数指定对象的invoke方法
         */
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader()
                ,this.targetObject.getClass().getInterfaces(), this);

    }


    /**　
     * @param proxy 指代我们所代理的那个真实对象
     * @param method   指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args  指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        UserServiceImpl service=(UserServiceImpl) this.targetObject;
        Object result=null;
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before service方法执行...");
        if(service.getUser()!=null){//判断权限
            // 把方法调用委派给目标对象
            result=method.invoke(targetObject, args);
        }
        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after service方法执行...");
        return result;
    }

    public static void main(String[] args) {
//        test1();

        test2();

    }

    public static void test1(){
        UserService userService=(UserService) new JDKProxyFactory()
                .createProxyInstance(new UserServiceImpl());
        userService.add("哈哈");
    }

    public static void test2(){
        UserService userService=(UserService) new JDKProxyFactory()
                .createProxyInstance(new UserServiceImpl("admin"));
        userService.add("哈哈");
    }
}

/**
 * Proxy类的newProxyInstance静态方法
 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
 *
 * 三个参数的含义:
 * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 *
 *
 * InvocationHandler接口
 *  每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。
 */