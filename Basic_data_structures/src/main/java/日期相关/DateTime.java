package 日期相关;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author chengzhen
 * @date 2020/12/3
 * @time 9:10 上午
 */
public class DateTime {


    public static void main(String[] args) {
//        testLocalDateClass();
        LocalDateTime localDateTime = LocalDateTime.parse("2020-12-08T01:00:00.000000");
        System.out.println(localDateTime);

    }

    public static void testLocalDateClass(){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        for(int i = 0; i < 3; i++){
            LocalDateTime localDateTime1 = LocalDateTime.now();
            LocalDateTime localDateTime2 = localDateTime1.minusDays(i);
            String s =  localDateTime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(s);
        }




    }

    public static void testJSONObject(){
        JSONObject params = JSONObject.parseObject(null);
        String ss = params.getString("ss");
        System.out.println(ss);
    }
}
