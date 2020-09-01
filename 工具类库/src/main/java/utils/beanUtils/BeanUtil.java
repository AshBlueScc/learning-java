package utils.beanUtils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/21
 * @time 下午3:46
 */

public class BeanUtil {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();

    }



    //设置javaBean的参数
    public static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //先演示一下不用工具时的做法
        //1.生成对象
        Student s = new Student();

        /*2.通过set方法赋值
        s.setId(1);
        s.setName("VN");
        s.setAge(19);
        s.setClassID(5);
        s.setBirthday(new Date());
        用以上这种方法来给对象的属性赋值实在是太麻烦了，下面我们用BeanUtils来进行赋值
        */

        //1.得到javaBean的一个字节码对象
        Class clazz = Class.forName("utils.beanUtils.Student");


        //2.生成该字节码的一个对象
        Object obj = clazz.newInstance();

        //4.注册一个日期格式转换器
        ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);

        //3.使用工具对该对象进行赋值
        //注意： 对于基本数据类型，beanutils工具进行自动类型转换。把String自动转成Integer,Double,Float
        BeanUtils.setProperty(obj, "id", "1");
        BeanUtils.setProperty(obj, "name", "VN");
        BeanUtils.setProperty(obj, "age", "19");
        BeanUtils.setProperty(obj, "classId", "5");
        //如果要使用特殊的日期类型，则String->Date 不能自动转换,这时候就要注册一个转换器
        BeanUtils.setProperty(obj, "date", "1996-06-06");

        System.out.println(obj);

    }

    //我们可以写出一个通用的方法，可以把请求中的参数拷贝到javaBean对象中！
    public static <T>T requestToBean(HttpServletRequest request , Class<T> clazz)
    {
        //创建javaBean对象
        Object obj=null;
        try {
            obj=clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //得到请求中的每个参数
        Enumeration<String> enu = request.getParameterNames();
        while(enu.hasMoreElements())
        {
            //获得参数名
            String name = enu.nextElement();
            //获得参数值
            String value = request.getParameter(name);
            //然后把参数拷贝到javaBean对象中
            try {
                BeanUtils.setProperty(obj, name, value);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return (T)obj;
    }

    //把一个javaBean的属性拷贝到另一个javaBean对象中
    public static void test2() throws InvocationTargetException, IllegalAccessException {
        //1.生成对象
        Student s1 = new Student();
        Student2 s2 = new Student2();

        //2.通过set方法赋值
        s1.setId(1);
        s1.setName("VN");
        //s1.setAge(19);//基本数据类型可以为null，null也能拷贝
        s1.setClassId(5);
        s1.setDate(new Date());//特殊类型不能为null

        //需求：把s1的属性值拷贝到S2中，注意参数的顺序
        BeanUtils.copyProperties(s2, s1);

        System.out.println(s1);
        System.out.println(s2);
    }

    //把一个map集合中的数据拷贝到javaBean中
    public static void test3() throws Exception
    {
        //1.生成对象
        Map<String,Object> map = new HashMap<String,Object>();

        //2.给一些参数
        map.put("id", 2);
        map.put("name", "EZ");
        map.put("age", 22);
        map.put("classId", 3);
        map.put("date", new Date());

        //需求：把map的属性值拷贝到S中
        Student s = new Student();
        BeanUtils.copyProperties(s, map);

        System.out.println(s);
        System.out.println(map);
    }

    /**
     * 下面介绍一个新的概念，学会这个东西后，它能够和beanUtils组合写出更多的通用代码！方便我们的项目！

     元数据（MetaData）
     什么是数据库的元数据
     数据库中的元数据有三种：

     1）数据库元数据（DatabaseMetaData）：可以从connection对象中获取。
     这些元数据的信息包括：当前使用什么数据库，数据库的版本，数据库驱动的版本

     2）参数元数据(ParameterMetaData):可以从PreparedStatement中获取，指sql语句中的参数
     元数据的信息：参数的个数，以及每个参数的类型

     3)结果集元数据(ResultSetMetaData)：可以从ResultSet对象中获取
     元数据信息：结果集的列数，以及每列的名称
     */

    public static void test4()
    {
        //获取连接池
        ComboPooledDataSource pool = new ComboPooledDataSource("mysql");
        try {
//            pool.setDriverClass("com.mysql.jdbc.Driver");
//            pool.setJdbcUrl("jdbc:mysql://localhost:3306/du123?useUnicode=true&useSSL=false&characterEncoding=utf-8;");
//            pool.setUser("root");
//            pool.setPassword("admin");
//            //初始化
//            pool.setInitialPoolSize(2);
//            //设置最大的链接数
//            pool.setMaxPoolSize(2);

            //获取连接
            Connection conn = pool.getConnection();
            //获取数据库元数据
            DatabaseMetaData md =     conn.getMetaData();

            //获得数据库的主版本和副版本
            int mj = md.getDatabaseMajorVersion();
            int mi =md.getDatabaseMinorVersion();
            System.out.println(mj + "."+ mi);

            //获得驱动版本
            int dmj = md.getDriverMajorVersion();
            int dmi = md.getDriverMinorVersion();
            System.out.println(dmj + "."+dmi);

            //当前使用什么数据库
            String b =md.getDatabaseProductName();
            System.out.println(b);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test5() throws Exception
    {
        //1.生成对象
        Student s1 = new Student();
        s1.setId(1);
        System.out.println("ssss"+s1);


        //需求：把map的属性值拷贝到S中
        Student2 s2 = new Student2();
        BeanUtils.copyProperties(s1, s2);

        System.out.println(s2);
    }
}
