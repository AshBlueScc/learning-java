package utils.randomStringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/25
 * @time 下午4:16
 */
public class Demo {
    public static void main(String[] args) {
        String nums = RandomStringUtils.random(6, 1, 100, false, true);
        System.out.println(nums);

        String strs = RandomStringUtils.random(6, true, false);
        System.out.println(strs);

        String numStrs = RandomStringUtils.random(6, true, true);
        System.out.println(numStrs);
    }
}
