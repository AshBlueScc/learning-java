package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_CGLib之Enhancer;

import org.springframework.cglib.proxy.*;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 2:38 PM
 */
public class EnhancerTest {

    public static void main(String[] args) throws Exception {
//        Hello hello = new Hello();
//        ProxyFactory cglibProxy = new ProxyFactory();
//        Hello proxy = (Hello) cglibProxy.createProxy(hello);
//        String result = proxy.sayHello(false);
//        System.out.println(result);

        //测试FixedValue
        System.out.println("测试FixedValue:");
        testFixedValue();

        System.out.println("测试InvocationHandler:");
        //测试InvocationHandler
        testInvocationHandler();

        System.out.println("测试MethodInterceptor");
        testMethodInterceptor();
    }

    public String test(){
        return "aaa";
    }

    //测试FixedValue
    public static void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerTest.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });
        EnhancerTest proxy = (EnhancerTest) enhancer.create();
        Assert.hasText("Hello cglib!", proxy.test());

    }

    //测试InvocationHandler
    public static void testInvocationHandler(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerTest.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    System.out.println(method.getDeclaringClass() + "||" + Object.class + "||" + method.getReturnType() );
                    return "Hello cglib!";
                } else {
                    System.out.println(method.getDeclaringClass() + "||" + Object.class + "||" + method.getReturnType() );
                    throw new RuntimeException("Do not know what to do.");
                }
            }
        });
        EnhancerTest proxy = (EnhancerTest) enhancer.create();
        Assert.hasText("Hello cglib!", proxy.test());
        Assert.hasText("Hello cglib!", proxy.toString());
    }


    //测试MethodInterceptor
    public static void testMethodInterceptor(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    System.out.println(method.getDeclaringClass() + "||" + Object.class + "||" + method.getReturnType() );
                    return "Hello cglib!";
                } else {
                    System.out.println(method.getDeclaringClass() + "||" + Object.class + "||" + method.getReturnType() );
                    //invokeSuper()会跳出当前callBack，进入下一个callBack处理
                    return proxy.invokeSuper(obj, args);
                    //invoke()不会跳出当前callBack，会调用当前callBack一次由于失败会循环掉用
//                    return proxy.invoke(obj, args);
                }
            }
        });
        EnhancerTest proxy = (EnhancerTest)enhancer.create();
        Assert.hasText("Hello cglib!", proxy.test());
        Assert.hasText("Hello cglib!", proxy.toString());
        proxy.hashCode();

    }
    
    //如果注视掉则掉用的是Object是的toString方法，此时     method.getDeclaringClass() == Object.class
    //如果不注视掉则method.getDeclaringClass() != Object.class则掉用的是EnhancerTest的toString，则method.getDeclaringClass() = EnhancerTest
    @Override
    public String toString() {
        return "EnhancerTest{}";
    }
}
