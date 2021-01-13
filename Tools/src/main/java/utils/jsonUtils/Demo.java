package utils.jsonUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/25
 * @time 下午4:16
 */
public class Demo {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";

        //String -> Class
        Map map = JSON.parseObject(str, Map.class);
        System.out.println(map);

        //Class -> Object(String)
        System.out.println(JSONObject.toJSON(map));

    }
}
