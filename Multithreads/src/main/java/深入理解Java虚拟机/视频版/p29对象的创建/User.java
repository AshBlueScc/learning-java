package 深入理解Java虚拟机.视频版.p29对象的创建;

import lombok.Data;

import java.util.Date;

/**
 * @author chengzhen
 * @date 2020/6/3
 * @time 下午7:07
 */
@Data
public class User {
    private String name;
    private int age;
    private Date birth;
    private boolean flag;

    public User(){
        System.out.println("user create ...");
    }
}
