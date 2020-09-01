package 深入理解Java虚拟机.读书版.过程中学习额外知识.Chapter243_额外相关_AOP_JDK的Proxy技术;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 5:23 PM
 *
 */
public class UserServiceImplAuth{
    //假设有该user是个User对象
    private String user=null;
    public String getUser(){
        return user;
    }
    public UserServiceImplAuth(){
    }
    public UserServiceImplAuth(String user){
        this.user=user;
    }
    public void add(String name) {
        if(user!=null){
            System.out.println("我要增加");
        }else{
            System.out.println("没有权限");
        }
    }
    public void delete(int id) {
        if(user!=null){
            System.out.println("我要删除");
        }else{
            System.out.println("没有权限");
        }
    }
}
