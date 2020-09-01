package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_CGLib之Enhancer;

/**
 * @author chengzhen
 * @date 2020/8/19
 * @time 6:45 PM
 */
public class Hello {
    public String sayHello(boolean throwException) throws Exception {
        System.out.println("hello everyone!");
        if(throwException)
            throw new Exception("test exception");
        return "123";
    }

}

