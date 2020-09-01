package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 5:22 PM
 */
public class UserServiceImpl implements UserService{
    //假设有该user是个User对象
    private String user=null;
    public String getUser(){
        return user;
    }
    public UserServiceImpl(){
    }
    public UserServiceImpl(String user){
        this.user=user;
    }

    @Override
    public void add(String name) {
        System.out.println("我要增加");
    }
    @Override
    public void delete(int id) {
        System.out.println("我要删除");
    }


}
