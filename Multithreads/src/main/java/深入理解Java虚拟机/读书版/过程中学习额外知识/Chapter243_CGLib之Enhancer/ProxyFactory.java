package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_CGLib之Enhancer;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chengzhen
 * @date 2020/8/19
 * @time 6:45 PM
 */
public class ProxyFactory implements MethodInterceptor {
    //要代理的原始对象
    private Object obj;
    public Object createProxy(Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());// 设置代理目标
        enhancer.setCallback(this);// 设置回调
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }



    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        try {
            // 前置通知
            before();
            result = proxy.invokeSuper(obj, args);
            // 后置通知
            after();
        } catch (Exception e) {
            exception();
        }finally{
            beforeReturning();
        }
        return result;

    }

    private void before() {
        System.out.println("before method invoke");
    }
    private void after() {
        System.out.println("after method invoke");
    }
    private void exception() {
        System.out.println("method invoke exception");
    }
    private void beforeReturning() {
        System.out.println("before returning");
    }

}
