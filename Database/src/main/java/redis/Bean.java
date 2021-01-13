package redis;

import lombok.Data;

import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/4/25
 * @time 下午6:52
 */
@Data
public class Bean {
    private String appid;
    private String enterpriseid;
    private String openid;
    private Map ledger;
    private Map recharge;

}
