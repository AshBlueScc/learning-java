package utils.beanUtils.test1;

import lombok.Data;

import java.util.List;

/**
 * @author chengzhen
 * @date 2020/7/24
 * @time 下午3:34
 */
@Data
public class ServiceKindSpecs {
    private Long id;
    private Long serviceKindSpecsId;
    private String serviceKindId;
    private Long price;
    private Integer specs;
    private Long fxDealerId;
    private Long currentLevelPrice;
    private Long lowerLevelPrice;
    private Boolean dealer3Use;
    private Boolean enable;
    List<AddedServiceKindSpecs> addedServiceKindSpecs;
}
