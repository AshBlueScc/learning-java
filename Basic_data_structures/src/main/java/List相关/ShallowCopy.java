package List相关;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 4:58 PM
 * 四种浅拷贝方法
 */
public class ShallowCopy {

    //1。遍历循环复制
    public static void traverseLoopCopy(){
        List<Integer> srcList = Lists.newArrayList(999999, 2);
        List<Integer> destList = new ArrayList<>(srcList.size());
        srcList.forEach(o->{
            destList.add(o);
        });
        System.out.println("添加前 srcList:"+srcList+",desList:"+destList);
        srcList.add(3);
        System.out.println("添加后 srcList:"+srcList+",desList:"+destList);
        srcList.set(0, 9999);
        System.out.println("修改后 srcList:"+srcList+",desList:"+destList);
        //基本类型改变不会互相影响
    }

    //2.使用List实现类的构造方法
    public static void constructMehtod(){
        List<Person> srcList = Lists.newArrayList(Person.create("s1", 2), Person.create("s2", 3));
        List<Person> destList=new ArrayList<Person>(srcList);
        System.out.println("修改前 srcList:"+srcList+",desList:"+destList);
        srcList.get(0).setName("修改后的s1");
        srcList.get(0).setAge(4);
        System.out.println("修改后 srcList:"+srcList+",desList:"+destList);
        //引用类型改变会互相影响
    }

    //3.使用list.addAll()方法
    public static void addAll(){
        List<Person> srcList = Lists.newArrayList(Person.create("s1", 2), Person.create("s2", 3));
        List<Person> destList=new ArrayList<Person>();
        destList.addAll(srcList);
        System.out.println("srcList:"+srcList+",desList:"+destList);
    }

    //4.使用System.arraycopy()方法
    public static void arrayCopy(){
        List<Person> srcList = Lists.newArrayList(Person.create("s1", 2), Person.create("s2", 3));
        Person[] srcPersons = srcList.toArray(new Person[0]);
        Person[] destPersons = new Person[srcPersons.length];
        System.arraycopy(srcPersons, 0, destPersons, 0, srcPersons.length);
        System.out.println("修改前 srcPersons:"+ Arrays.toString(srcPersons)+",destPersons:"+Arrays.toString(destPersons));
        srcPersons[0].setName("修改后的s1");
        System.out.println("修改后 srcPersons:"+Arrays.toString(srcPersons)+",destPersons:"+Arrays.toString(destPersons));
    }


    public static void main(String[] args) {
//        traverseLoopCopy();
//        constructMehtod();
//        addAll();
//        arrayCopy();
    }

}
