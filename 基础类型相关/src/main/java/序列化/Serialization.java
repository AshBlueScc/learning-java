package 序列化;

import java.io.*;
import java.util.Arrays;

/**
 * @author chengzhen
 * @date 2020/9/2
 * @time 10:52 AM
 * 序列化
 */
public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));


        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()))) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.println("n:" + n + "||s:" + s + "||d:" + d);
        }
    }
    //ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object。
    //
    //因为写入Object时需要大量的类型信息，所以写入的内容很大。

}


//参考：https://www.liaoxuefeng.com/wiki/1252599548343744/1298366845681698