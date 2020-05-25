package utils.beanUtils;

import lombok.Data;

import java.util.Date;

/**
 * @author chengzhen
 * @date 2020/4/21
 * @time 下午4:00
 */
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private int classId;
    private Date date;

}
