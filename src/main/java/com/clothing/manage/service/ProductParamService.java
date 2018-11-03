package com.clothing.manage.service;

import com.clothing.manage.model.ProductParam;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品规格参数
 *
 * @author partner
 * @create 2018-11-03 17:17
 */
public interface ProductParamService {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductParam record);

    int insertSelective(ProductParam record);

    ProductParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductParam record);

    int updateByPrimaryKey(ProductParam record);

    /**
     * 根据商品Id获取商品规格参数
     * @param productId
     * @return
     */
    List<Map> selectProductParamByProductId(Integer productId);
}
