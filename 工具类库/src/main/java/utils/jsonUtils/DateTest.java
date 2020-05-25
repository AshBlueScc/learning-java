package utils.jsonUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.code.Attribute;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/27
 * @time 上午11:54
 */
public class DateTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("1994-11-23");
            System.out.println(date);
            LocalDate ld = new LocalDate(System.currentTimeMillis());

            DateTime now = DateTime.now();
            ld = now.toLocalDate();
            System.out.println(ld);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String data = "{\n" +
                "    \"data\": {\n" +
                "        \"first\": {\n" +
                "            \"value\": \"您的账号已在其他微信端登录\",\n" +
                "            \"color\": \"#173177\"\n" +
                "        },\n" +
                "        \"keyword1\": {\n" +
                "            \"value\": \"手机号验证码登录\",\n" +
                "            \"color\": \"#173177\"\n" +
                "        },\n" +
                "        \"keyword2\": {\n" +
                "            \"value\": \"" + 111 + "\",\n" +
                "            \"color\": \"#173177\"\n" +
                "        },\n" +
                "        \"remark\": {\n" +
                "            \"value\": \"如非本人操作，请您点击此消息重新登录\",\n" +
                "            \"color\": \"#173177\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSONObject jsonObject = (JSONObject)JSON.parse(data);
        jsonObject.put("touser",111);
        System.out.println(jsonObject);

        JSONObject req = new JSONObject();
        req.put("data", ((JSONObject)JSON.parse(data)).get(data));
        req.put("touser", 111);

        System.out.println(req);


    }
}
