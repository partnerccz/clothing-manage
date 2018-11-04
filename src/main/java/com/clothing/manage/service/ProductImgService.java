package com.clothing.manage.service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品图片服务接口
 *
 * @author partner
 * @create 2018-11-04 12:46
 */
public interface ProductImgService {


    /**
     * 根据商品ID获取商品集合
     * @param productId
     * @return
     */
    List<Map> getProductImgByProductId(Integer productId);
}
