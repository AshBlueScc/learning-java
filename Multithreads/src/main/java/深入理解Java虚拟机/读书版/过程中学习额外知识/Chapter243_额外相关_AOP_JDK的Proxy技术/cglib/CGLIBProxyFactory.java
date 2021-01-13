package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术.UserServiceImplAuth;

import java.lang.reflect.Method;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 7:35 PM
 */
public class CGLIBProxyFactory implements MethodInterceptor{	//代理的目标对象

    private Object targetObject;
    //产生一个代理对象
    public Object createProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        //用于生成代理对象
        Enhancer enhancer=new Enhancer();
        //设置目标类为代理对象的父类
        enhancer.setSuperclass(this.targetObject.getClass());
        //设置回调对象为本身
        enhancer.setCallback(this);
        //生成一个代理类对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object object, Method method, Object[] arg,
                            MethodProxy methodProxy) throws Throwable {
        UserServiceImplAuth service=(UserServiceImplAuth) this.targetObject;
        Object result = null;
        //在代理真实对象方法执行前我们可以添加一些自己的操作
        System.out.println("Before 真实对象方法执行...");
        if(service.getUser()!=null){//判断权限
            result=methodProxy.invoke(targetObject, arg);
        }
        //在代理真实对象方法执行后我们也可以添加一些自己的操作
        System.out.println("After 真实对象方法执行...");
        return result;
    }

    public static void main(String[] args) {
//        test1();

        test2();
    }

    public static void test1(){
        //UserServiceImplAuth不设置user值--没有对象
        UserServiceImplAuth service=(UserServiceImplAuth) new CGLIBProxyFactory().
                createProxyInstance(new UserServiceImplAuth());
        service.add("哈哈");
    }

    public static void test2(){
        //UserServiceImplAuth不设置user值--没有对象
        UserServiceImplAuth service=(UserServiceImplAuth) new CGLIBProxyFactory().
                createProxyInstance(new UserServiceImplAuth("admin"));
        service.add("哈哈");
    }
}
