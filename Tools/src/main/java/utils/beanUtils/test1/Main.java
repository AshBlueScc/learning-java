package utils.beanUtils.test1;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import utils.beanUtils.BeanUtil;

import java.lang.reflect.InvocationTargetException;

/**
 * @author chengzhen
 * @date 2020/8/13
 * @time 4:09 PM
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        String s = "ServiceKindSpecs(id=281, serviceKindSpecsId=738, serviceKindId=dcae9e9f40d04719956521e2d98017e3, price=300, specs=3, fxDealerId=null, currentLevelPrice=null, lowerLevelPrice=null, dealer3Use=null, enable=null, addedServiceKindSpecs=[AddedServiceKindSpecs(fxDealerId=null, currentLevelPrice=308, lowerLevelPrice=330, dealer3Use=true, enable=null)])";
        String s2 = "AddedServiceKindSpecs(fxDealerId=null, currentLevelPrice=308, lowerLevelPrice=330, dealer3Use=true, enable=null)";
        ServiceKindSpecs serviceKindSpecs = new ServiceKindSpecs();
        serviceKindSpecs.setId(281l);
        serviceKindSpecs.setServiceKindSpecsId(738l);
        serviceKindSpecs.setServiceKindId("dcae9e9f40d04719956521e2d98017e3");
        serviceKindSpecs.setPrice(300l);
        serviceKindSpecs.setSpecs(3);
        AddedServiceKindSpecs addedServiceKindSpecs = new AddedServiceKindSpecs();
        addedServiceKindSpecs.setCurrentLevelPrice(308l);
        addedServiceKindSpecs.setLowerLevelPrice(330l);
        addedServiceKindSpecs.setDealer3Use(true);
        System.out.println(serviceKindSpecs);
        System.out.println(addedServiceKindSpecs);
        BeanUtils.copyProperties(addedServiceKindSpecs,serviceKindSpecs);
        System.out.println(serviceKindSpecs);
        System.out.println(addedServiceKindSpecs);


    }
}
