package 异常测试;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author chengzhen
 * @date 2020/10/21
 * @time 9:30 AM
 */
public class JsonTest {


    public static void main(String[] args) throws Exception {
//        String s = "{\"description\":\"选择一张卡，对卡的套餐进行开通\",\"imgName\":\"默认图片.jpg\",\"bannerSrc\":\"/login/static/img/banner.a29c63c6.jpg\",\"bannerPath\":\"\",\"payConfigs\":[{\"type\":\"wxPay\",\"icon\":\"/login/static/img/pay-wx.635c246b.jpg\",\"enable\":true,\"id\":18,\"selectRow\":{\"id\":18,\"cardEnterpriseId\":30,\"mchId\":\"1565095421\",\"type\":\"RECEIVE\",\"mchName\":\"21商户号\",\"remarks\":\"备注\",\"status\":\"NORMAL\",\"secretKey\":\"b******l\",\"certificatePwd\":\"1******1\",\"certificateUpdated\":true,\"mchPayAuthRooturi\":[\"https://iotpine.com/\",\"https://iotpine.com/website/\"],\"relatedWechat\":[\"赛贝尔（wx1fe38888dc886611）\"]},\"accounts\":[{\"id\":18,\"cardEnterpriseId\":30,\"mchId\":\"1565095421\",\"type\":\"RECEIVE\",\"mchName\":\"21商户号\",\"remarks\":\"备注\",\"status\":\"NORMAL\",\"secretKey\":\"b******l\",\"certificatePwd\":\"1******1\",\"certificateUpdated\":true,\"mchPayAuthRooturi\":[\"https://iotpine.com/\",\"https://iotpine.com/website/\"],\"relatedWechat\":[\"赛贝尔（wx1fe38888dc886611）\"]},{\"id\":19,\"cardEnterpriseId\":30,\"mchId\":\"1600918648\",\"type\":\"RECEIVE\",\"mchName\":\"蜂巢物联现网测试\",\"remarks\":\"现网备注\",\"status\":\"NORMAL\",\"secretKey\":\"b******2\",\"certificatePwd\":\"1******8\",\"certificateUpdated\":true,\"mchPayAuthRooturi\":[\"https://iotpine.com/\",\"https://iotpine.com/website/\"],\"relatedWechat\":[\"蜂巢物联（wxbf7d1f996d93936e）\"]},{\"id\":26,\"cardEnterpriseId\":30,\"mchId\":\"1546938811\",\"type\":\"RECEIVE\",\"mchName\":\"1546938811\",\"remarks\":\"\",\"status\":\"NORMAL\",\"secretKey\":\"b******F\",\"certificatePwd\":\"1******1\",\"certificateUpdated\":true,\"mchPayAuthRooturi\":[\"https://iotpine.com/\",\"https://iotpine.com/website/\"],\"relatedWechat\":[]}]},{\"type\":\"aliPay\",\"icon\":\"/login/static/img/pay-alipay.163a990c.png\",\"enable\":true,\"id\":4,\"selectRow\":{\"id\":4,\"enterpriseId\":30,\"authAppId\":\"2016102400748096\",\"type\":\"RECEIVE\",\"remarks\":\"\",\"status\":\"STOP\",\"mchId\":\"2016102400748096\",\"mchName\":\"2016102400748096\"},\"accounts\":[{\"id\":4,\"enterpriseId\":30,\"authAppId\":\"2016102400748096\",\"type\":\"RECEIVE\",\"remarks\":\"\",\"status\":\"STOP\",\"mchId\":\"2016102400748096\",\"mchName\":\"2016102400748096\"}]}]}";
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        JSONArray payConfigs = jsonObject.getJSONArray("payConfigs");
//        if(payConfigs == null){
//            throw new Exception("");
//        }
//        for(int i = 0; i < payConfigs.size(); i++){
//            if(payConfigs.getJSONObject(i).getString("type").equalsIgnoreCase("wxPay")){
//                Integer id = payConfigs.getJSONObject(i).getInteger("id");
//                System.out.println(id);
//            }
//        }

        String s = "12345";
        System.out.println(s.charAt(1));
        System.out.println(s.indexOf('1'));


    }
}
