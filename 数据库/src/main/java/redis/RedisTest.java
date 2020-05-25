package redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/25
 * @time 下午4:55
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的redis
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("root");


           jedis.hset("cid", "appid", "1");
           jedis.hdel("cid", "appid");



        jedis.hset("cid", "openid", "2");
        jedis.hset("cid", "enterpriseid", "3");

        Map ledger = new HashMap();
        ledger.put("ledger1", "value1");
        ledger.put("ledger2", "value2");
        ledger.put("ledger3", "value3");
        System.out.println(ledger);
        jedis.hset("cid", "ledger", JSONObject.toJSON(ledger).toString());

        Map recharge = new HashMap();
        recharge.put("recharge1", "value1");
        recharge.put("recharge2", "value2");
        recharge.put("recharge3", "value3");

        System.out.println(JSONObject.parseObject(jedis.hget("cid", "ledger"), Map.class));

        jedis.hset("cid", "recharge", JSONObject.toJSON(recharge).toString());

        //Map转化成json
        Map map = jedis.hgetAll("cid");
        JSONObject jb = (JSONObject) JSONObject.toJSON(map);

        System.out.println(jb.getJSONObject("ledger").toString());
        Map led = JSONObject.parseObject(jb.getJSONObject("ledger").toString(), Map.class);
        System.out.println(led);
//        Bean bean = JSONObject.parseObject(JSONObject.toJSONString(map, true), Bean.class);
//        System.out.println("bean:"+bean.toString());

        System.out.println("openid:" + jb.getString("openid"));
        System.out.println("map -> jsonObject" + jb);
        System.out.println("map:"+map);
        String jsonStr = JSONObject.toJSONString(map, true);
        System.out.println("json:"+jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println("jsonObject:" + jsonObject);

       //json转化成map
        Map map1 = JSON.parseObject(jsonStr);
        System.out.println("map1:" + map1);


//        System.out.println(jedis.getClient().getPort());
//        System.out.println("连接本地的Redis服务器成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行：" + jedis.ping());
        jedis.close();

    }
}

